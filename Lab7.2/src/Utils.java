import static java.util.Arrays.asList;
import java.util.List;

public class Utils
{
    static final List<String> keywords = asList
            (
                    "abstract",	"continue",	"for",	"new",	"switch",
                    "assert",	"default",	"goto*",	"package",	"synchronized",
                    "boolean",	"do",	"if",	"private",	"this",
                    "break",	"double",	"implements",	"protected",	"throw",
                    "byte",	"else", "import",	"public",	"throws",
                    "case",	"enum",	"instanceof",	"return",	"transient",
                    "catch",	"extends",	"int",	"short",	"try",
                    "char",	"final",	"interface",	"static",	"void",
                    "class",	"finally",	"long",	"strictfp",	"volatile",
                    "const*",	"float",	"native",	"super",	"while"
            );

    public static boolean isKeyword(String word)
    {
        for(int i = 0; i < keywords.size(); i++)
        {
            if (word.equals(keywords.get(i)))
            {
                return true;
            }
        }
        return false;
    }

}