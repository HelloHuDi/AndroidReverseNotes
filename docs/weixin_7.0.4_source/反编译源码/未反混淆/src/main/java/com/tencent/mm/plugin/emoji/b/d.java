package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

public interface d extends a {
    aq getEmojiDescMgr();

    com.tencent.mm.pluginsdk.a.d getEmojiMgr();

    at getEmojiStorageMgr();

    e getProvider();

    void removeEmojiMgr();

    void setEmojiMgr();
}
