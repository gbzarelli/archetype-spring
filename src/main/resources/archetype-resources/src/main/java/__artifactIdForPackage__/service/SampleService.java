package ${customPackage}.service;

import ${customPackage}.exception.RegisterException;
import ${customPackage}.exception.ValidateRegisterException;
import ${customPackage}.model.entity.SampleEntity;
import ${customPackage}.model.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class auto-generated by archetype-spring project
 * Repository: http://californio.keynet.com.br:8089/java/archetype/archetype-spring
 */
@Service
public class SampleService {

    private static final int MAX_AGE_ACCEPT = 150;

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public SampleEntity register(SampleEntity entity) throws RegisterException, ValidateRegisterException {
        checkAgeToRegister(entity);
        SampleEntity returnEntity = sampleRepository.getSampleEntityForName(entity.getName());
        if (returnEntity != null) return returnEntity;
        return sampleRepository.register(entity);
    }

    private void checkAgeToRegister(SampleEntity entity) throws ValidateRegisterException {
        if (entity.getAge() > MAX_AGE_ACCEPT) {
            throw new ValidateRegisterException("Exception for sample");
        }
    }

}
