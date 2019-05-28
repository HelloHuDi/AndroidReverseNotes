package com.tencent.p177mm.pluginsdk.p1336a;

import android.content.Context;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p707ba.C6337f;
import com.tencent.p177mm.storage.C23504as;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.C40628r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.a.d */
public interface C44795d extends C44039e {
    /* renamed from: Jd */
    EmojiInfo mo35596Jd(String str);

    /* renamed from: Jf */
    String mo35598Jf(String str);

    /* renamed from: Jg */
    List<EmojiInfo> mo35599Jg(String str);

    /* renamed from: Ji */
    boolean mo35601Ji(String str);

    /* renamed from: Jj */
    ArrayList<String> mo35602Jj(String str);

    /* renamed from: Jk */
    String mo35603Jk(String str);

    /* renamed from: Jl */
    String mo35604Jl(String str);

    /* renamed from: Jm */
    int mo35605Jm(String str);

    /* renamed from: Jn */
    String mo35606Jn(String str);

    /* renamed from: Jo */
    void mo35607Jo(String str);

    /* renamed from: a */
    EmojiInfo mo35615a(String str, String str2, int i, int i2, int i3, String str3);

    /* renamed from: a */
    String mo35616a(Context context, WXMediaMessage wXMediaMessage, String str);

    /* renamed from: a */
    void mo35617a(Context context, C7620bi c7620bi, String str);

    /* renamed from: a */
    void mo35620a(String str, EmojiInfo emojiInfo, C7620bi c7620bi);

    /* renamed from: a */
    boolean mo35621a(Context context, EmojiInfo emojiInfo, int i, String str);

    /* renamed from: a */
    boolean mo35623a(String str, String str2, long j, String str3, C1197a c1197a);

    boolean bjN();

    ArrayList<C40628r> bjP();

    C6337f bjQ();

    boolean bjR();

    String bjS();

    /* renamed from: c */
    boolean mo35642c(EmojiInfo emojiInfo, boolean z);

    /* renamed from: d */
    int mo35643d(EmojiInfo emojiInfo, boolean z);

    /* renamed from: dK */
    C23504as mo35645dK(String str, String str2);

    /* renamed from: dL */
    String mo35646dL(String str, String str2);

    /* renamed from: l */
    byte[] mo35656l(EmojiInfo emojiInfo);

    /* renamed from: o */
    int mo35658o(EmojiInfo emojiInfo);

    /* renamed from: p */
    int[] mo35660p(EmojiInfo emojiInfo);

    /* renamed from: r */
    boolean mo35663r(Context context, String str, String str2);

    void updateEmojiInfo(EmojiInfo emojiInfo);

    /* renamed from: w */
    boolean mo35665w(ArrayList<SmileyInfo> arrayList);

    /* renamed from: x */
    boolean mo35666x(ArrayList<C40628r> arrayList);
}
