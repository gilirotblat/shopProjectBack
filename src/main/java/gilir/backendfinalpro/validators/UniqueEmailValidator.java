package gilir.backendfinalpro.validators;


import gilir.backendfinalpro.entity.User;
import gilir.backendfinalpro.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findByEmailIgnoreCase(email);

        //if user does not exist -> VALID
        return user.isEmpty();
    }
}