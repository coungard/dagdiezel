package org.coungard.dagdiezel.tools.sequence;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.persister.entity.EntityPersister;

public class IncrementByMaxIdGenerator implements IdentifierGenerator, Configurable {

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

    EntityPersister entityPersister = session.getEntityPersister(obj.getClass().getName(), obj);
    String query = String.format("select %s from %s",
        entityPersister.getIdentifierPropertyName(),
        entityPersister.getPropertySpaces()[0]); // ? why spaces idk, need entity name , like a game/scoring

      List<Long> ids = (List<Long>) session.createQuery(query).stream().collect(Collectors.toList());

    return ids.isEmpty() ? 1 : Collections.max(ids) + 1;
  }
}