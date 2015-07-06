package io.fedcuit.github.java8.chapter5;

public class StringCombiner {
    private final String delim;
    private final String prefix;
    private final String suffix;
    private final StringBuilder stringBuilder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        stringBuilder = new StringBuilder();
    }

    public StringCombiner add(String s) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(delim);
        }
        stringBuilder.append(s);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        stringBuilder.append(other.getStringBuilder());
        return this;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public String build() {
        return String.format("%s%s%s", prefix, stringBuilder.toString(), suffix);
    }
}
