package org.jgspark.reader;

public interface Reader {

    <T> T readJson(Class<T> type);
}
