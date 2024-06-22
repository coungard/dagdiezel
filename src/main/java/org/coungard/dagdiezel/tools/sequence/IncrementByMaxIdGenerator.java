package org.coungard.dagdiezel.tools.sequence;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

public class IncrementByMaxIdGenerator implements IdentifierGenerator, Configurable {

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

    String query = String.format("select %s from %s",
        session.getEntityPersister(obj.getClass().getName(), obj)
            .getIdentifierPropertyName(),
        obj.getClass().getSimpleName());

    List<Long> ids = (List<Long>) session.createQuery(query).stream().collect(Collectors.toList());

    return ids.isEmpty() ? 1 : Collections.max(ids) + 1;
  }
}