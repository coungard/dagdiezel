package org.coungard.dagdiezel.tools.sequence;

import java.util.Properties;
import lombok.RequiredArgsConstructor;
import org.coungard.dagdiezel.repository.ScoringRepository;
import org.hibernate.MappingException;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScoringSequenceGenerator extends SequenceStyleGenerator {

  private final ScoringRepository scoringRepository;

  @Override
  public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
      EventType eventType) {
    return scoringRepository.getMaxId() + 1;
  }

  @Override
  public void initialize(SqlStringGenerationContext context) {
    super.initialize(context);
  }

  @Override
  public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
    super.configure(type, parameters, serviceRegistry);
  }
}
