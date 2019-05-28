package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.at.a.a;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.t;
import java.util.ArrayList;
import java.util.List;

public interface e {
    EmojiInfo Je(String str);

    String Jh(String str);

    int Jp(String str);

    boolean Jq(String str);

    void Jr(String str);

    ArrayList<EmojiInfo> OC();

    ArrayList<EmojiGroupInfo> OD();

    boolean OS();

    boolean OT();

    void a(UploadTask uploadTask);

    void a(cab cab);

    boolean a(EmojiGroupInfo emojiGroupInfo);

    void b(UploadTask uploadTask);

    ArrayList<EmojiInfo> bY(boolean z);

    void bZ(String str, int i);

    ArrayList<SmileyInfo> bjO();

    void bjT();

    cab bjU();

    int bjV();

    a bjW();

    boolean bjX();

    List<t> bjY();

    void bjZ();

    boolean bka();

    <T> T c(ac.a aVar, T t);

    void d(ac.a aVar, Object obj);

    void g(k.a aVar);

    String getAccPath();

    void h(k.a aVar);

    void i(k.a aVar);

    EmojiInfo j(String str, int i, int i2, int i3);

    void j(k.a aVar);

    void k(k.a aVar);

    ArrayList<EmojiInfo> kS(String str);

    void l(k.a aVar);

    byte[] l(EmojiInfo emojiInfo);

    EmojiInfo n(EmojiInfo emojiInfo);

    void onDestroy();

    void q(EmojiInfo emojiInfo);

    void r(EmojiInfo emojiInfo);

    void updateEmojiInfo(EmojiInfo emojiInfo);

    int y(boolean z, boolean z2);
}
