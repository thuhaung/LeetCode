package String;

public class FindIndexOfFirstOccurence {
    public static int firstOccurence(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < haystack.length(); i++) {
            s.append(haystack.charAt(i));

            if (i + needle.length() <= haystack.length()) {
                for (int j = i + 1; j < i + needle.length(); j++) {
                    s.append(haystack.charAt(j));
                }

                System.out.println("s = " + s.toString());

                if (s.toString().equals(needle)) {
                    return i;
                }
            }

            s.setLength(0);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurence("mississipi", "issi"));
    }
}
