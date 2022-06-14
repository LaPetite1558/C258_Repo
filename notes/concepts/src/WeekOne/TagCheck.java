package WeekOne;/*
In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag
like <tag>contents</tag>. Note that the corresponding end tag starts with a /.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed
within sequences of well-organized tags meeting the following criterion:

    1) The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid,
    because the text starts with an h1 tag and ends with a non-matching h2 tag.

    2) Tags can be nested, but content between nested tags is considered not valid.
    For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.

    3) Tags can consist of any printable characters.
 */

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class TagCheck {
    public static void main(String[] args) {
        String html = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String[] hSplit = html.split(">");
        int n = hSplit.length;

        for (int i = n-1; i > 0; i--) {
            String eF = hSplit[i];
            String eL = hSplit[n-i];
            if (!eF.equals(eL.substring(1))) {
                out.println(eF + eL.substring(1));
            } else out.println("fck");
        }

        out.println(Arrays.toString(Arrays.stream(hSplit).toArray()));
//        Pattern p = Pattern.compile("\\b?(<(?<tag>(.+)>)*<?(?<tag2>(.+)>)*(\\w+.*)<*/*(\\k<tag2>)*</\\k<tag>*)+\\b?");
//        Matcher m = p.matcher(html);
//        out.println(m.matches());
//        out.println(m.groupCount());
//        out.println(m.group(6));

    }
}
