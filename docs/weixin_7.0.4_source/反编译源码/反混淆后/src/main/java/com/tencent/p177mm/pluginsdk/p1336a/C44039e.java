package com.tencent.p177mm.pluginsdk.p1336a;

import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C15438t;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.a.e */
public interface C44039e {
    /* renamed from: Je */
    EmojiInfo mo35597Je(String str);

    /* renamed from: Jh */
    String mo35600Jh(String str);

    /* renamed from: Jp */
    int mo35608Jp(String str);

    /* renamed from: Jq */
    boolean mo35609Jq(String str);

    /* renamed from: Jr */
    void mo35610Jr(String str);

    /* renamed from: OC */
    ArrayList<EmojiInfo> mo35611OC();

    /* renamed from: OD */
    ArrayList<EmojiGroupInfo> mo35612OD();

    /* renamed from: OS */
    boolean mo35613OS();

    /* renamed from: OT */
    boolean mo35614OT();

    /* renamed from: a */
    void mo35618a(UploadTask uploadTask);

    /* renamed from: a */
    void mo35619a(cab cab);

    /* renamed from: a */
    boolean mo35622a(EmojiGroupInfo emojiGroupInfo);

    /* renamed from: b */
    void mo35624b(UploadTask uploadTask);

    /* renamed from: bY */
    ArrayList<EmojiInfo> mo35625bY(boolean z);

    /* renamed from: bZ */
    void mo35626bZ(String str, int i);

    ArrayList<SmileyInfo> bjO();

    void bjT();

    cab bjU();

    int bjV();

    C25815a bjW();

    boolean bjX();

    List<C15438t> bjY();

    void bjZ();

    boolean bka();

    /* renamed from: c */
    <T> T mo35641c(C5127a c5127a, T t);

    /* renamed from: d */
    void mo35644d(C5127a c5127a, Object obj);

    /* renamed from: g */
    void mo35647g(C4931a c4931a);

    String getAccPath();

    /* renamed from: h */
    void mo35649h(C4931a c4931a);

    /* renamed from: i */
    void mo35650i(C4931a c4931a);

    /* renamed from: j */
    EmojiInfo mo35651j(String str, int i, int i2, int i3);

    /* renamed from: j */
    void mo35652j(C4931a c4931a);

    /* renamed from: k */
    void mo35653k(C4931a c4931a);

    /* renamed from: kS */
    ArrayList<EmojiInfo> mo35654kS(String str);

    /* renamed from: l */
    void mo35655l(C4931a c4931a);

    /* renamed from: l */
    byte[] mo35656l(EmojiInfo emojiInfo);

    /* renamed from: n */
    EmojiInfo mo35657n(EmojiInfo emojiInfo);

    void onDestroy();

    /* renamed from: q */
    void mo35661q(EmojiInfo emojiInfo);

    /* renamed from: r */
    void mo35662r(EmojiInfo emojiInfo);

    void updateEmojiInfo(EmojiInfo emojiInfo);

    /* renamed from: y */
    int mo35667y(boolean z, boolean z2);
}
