package com.tencent.mm.plugin.fts.a;

public interface i extends Comparable<i> {
    String ck(String str, int i);

    void create();

    void destroy();

    String getName();

    int getPriority();

    int getType();
}
