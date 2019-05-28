package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

public interface b {

    public static class a {
        public static b kTl;
    }

    aq getEmojiDescMgr();

    d getEmojiMgr();

    at getEmojiStorageMgr();
}
