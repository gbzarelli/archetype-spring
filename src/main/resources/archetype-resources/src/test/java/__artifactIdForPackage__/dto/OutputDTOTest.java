package ${customPackage}.dto;

import ${customPackage}.model.entity.SampleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class auto-generated by archetype-spring project
 * Repository: http://californio.keynet.com.br:8089/java/archetype/archetype-spring
 */
class OutputDTOTest {
    @Test
    void convert_from_sample_entity() {
        SampleEntity sampleEntity = new SampleEntity(1, "name", 2);
        OutputDTO outputDTO = OutputDTO.fromSampleEntity(sampleEntity);
        Assertions.assertEquals(outputDTO.getId(), sampleEntity.getId());
    }
}
