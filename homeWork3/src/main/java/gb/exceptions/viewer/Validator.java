package gb.exceptions.viewer;

import gb.exceptions.model.Human;

public interface Validator {
    Human validate(String[] rawData) throws Exception;
}
