import org.jetbrains.annotations.NotNull;

public class CharSeqImpl implements CharSequence {
    private final char[] charSeq;
    private final int offset;
    private final int count;

    public CharSeqImpl(char[] charSeq) {
        this(charSeq, 0, charSeq.length);
    }

    public CharSeqImpl(char[] charSeq, int count) {
        this(charSeq, 0, count);
    }

    public CharSeqImpl(char[] charSeq, int offset, int count) {
        this.charSeq = charSeq;
        this.offset = offset;
        this.count = count;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public char charAt(int index) {
        return charSeq[offset+index];
    }

    @NotNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public char[] reverse() {
        char[] backChars = new char[count];
        int backCount = 0;
        for (int i = count-1; i >= 0; i--) {
            backChars[backCount] = charSeq[i];
            backCount++;
        }
        return backChars;
    }

    @Override
    public String toString() {
        return String.valueOf(reverse());
    }
}

class CharTest {
    public static void main(String[] args) {
        char[] chars = "It's fun to stay at the Y.M.C.A!".toCharArray();
        CharSeqImpl charSeq = new CharSeqImpl(chars);

        System.out.println(charSeq);


    }
}
