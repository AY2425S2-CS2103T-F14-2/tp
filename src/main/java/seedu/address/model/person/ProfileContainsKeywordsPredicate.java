package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s full name or surname matches the keywords given
 */
public class ProfileContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    /**
     * Constructs a ProfileContainsKeywordsPredicate with the given keywords.
     *
     * @param keywords The list of keywords to match against.
     */
    public ProfileContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    @Override
    public boolean test(Person person) {
        String fullName = person.getName().fullName.trim().toLowerCase();

        for (String keyword : keywords) {
            if (fullName.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ProfileContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((ProfileContainsKeywordsPredicate) other).keywords)); // state check
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}

