package com.tencent.p177mm.plugin.emoji.p725b;

import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C44219aq;

/* renamed from: com.tencent.mm.plugin.emoji.b.d */
public interface C6835d extends C1677a {
    C44219aq getEmojiDescMgr();

    C44795d getEmojiMgr();

    C23505at getEmojiStorageMgr();

    C44039e getProvider();

    void removeEmojiMgr();

    void setEmojiMgr();
}
