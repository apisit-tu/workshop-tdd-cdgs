package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;

        // Validate input
        validateInput(speaker);

        // Save speaker
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    private void validateInput(Speaker speaker) {
        String[] domains = {"gmail.com", "live.com"};
        if (isNullOrEmpty(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (isNullOrEmpty(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (isNullOrEmpty(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }
        // Your Tasks ...
        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().equals("");
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}