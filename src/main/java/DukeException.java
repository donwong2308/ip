import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.time.format.DateTimeParseException;

public class DukeException extends Exception{
    public DukeException(String msg) {
        super(msg);
    }
    static void validateToDo(String str) throws DukeException {
        if (str.split(" ").length < 2) {
            throw new DukeException("ToDo Task Missing!");
        }
    }

    static void validateInstn(String str) throws DukeException {
        String[] instnArr = {"todo", "deadline", "event", "mark", "unmark", "list", "delete"};
        String instn = str.split(" ")[0].toLowerCase();
        if (!Arrays.asList(instnArr).contains(instn)) {
            throw new DukeException("Invalid instruction for PeWPeWPeW:(((");
        }
    }

    static void validateArrIndex(int index, ArrayList<Task> task_arr) throws DukeException {
        if (index >= task_arr.size()) {
            throw new DukeException("Your task number input is invalid, please try again");
        } else if (task_arr.get(index) == null) {
            throw new DukeException("Your task number input is invalid, please try again");
        }
    }

    static void validateDateTime(String str) throws DukeException {
        // Your existing validation code remains unchanged
        String[] dateFormats = {
                "M/d/yyyy[ HHmm]",
                "yyyy-MM-dd[ HHmm]",
                "dd-MM-yyyy[ HHmm]",
                "d/M/yyyy[ HHmm]",
                "M-d-yyyy[ HHmm]",
                "d-M-yyyy[ HHmm]"
        };

        boolean isValidFormat = false;

        for (String format : dateFormats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
                formatter.parse(str);
                isValidFormat = true;
                break;
            } catch (DateTimeParseException ignored) {
                // Ignore exception for the current format, try the next one
            }
        }

        if (!isValidFormat) {
            throw new DukeException("Invalid date and time format, use the following formats: " +
                    "\n" + Arrays.toString(dateFormats));
        }
    }
}
