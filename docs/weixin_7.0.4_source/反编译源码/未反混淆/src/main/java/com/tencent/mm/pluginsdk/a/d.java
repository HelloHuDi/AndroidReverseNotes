package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ba.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.r;
import java.util.ArrayList;
import java.util.List;

public interface d extends e {
    EmojiInfo Jd(String str);

    String Jf(String str);

    List<EmojiInfo> Jg(String str);

    boolean Ji(String str);

    ArrayList<String> Jj(String str);

    String Jk(String str);

    String Jl(String str);

    int Jm(String str);

    String Jn(String str);

    void Jo(String str);

    EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3);

    String a(Context context, WXMediaMessage wXMediaMessage, String str);

    void a(Context context, bi biVar, String str);

    void a(String str, EmojiInfo emojiInfo, bi biVar);

    boolean a(Context context, EmojiInfo emojiInfo, int i, String str);

    boolean a(String str, String str2, long j, String str3, a aVar);

    boolean bjN();

    ArrayList<r> bjP();

    f bjQ();

    boolean bjR();

    String bjS();

    boolean c(EmojiInfo emojiInfo, boolean z);

    int d(EmojiInfo emojiInfo, boolean z);

    as dK(String str, String str2);

    String dL(String str, String str2);

    byte[] l(EmojiInfo emojiInfo);

    int o(EmojiInfo emojiInfo);

    int[] p(EmojiInfo emojiInfo);

    boolean r(Context context, String str, String str2);

    void updateEmojiInfo(EmojiInfo emojiInfo);

    boolean w(ArrayList<SmileyInfo> arrayList);

    boolean x(ArrayList<r> arrayList);
}
