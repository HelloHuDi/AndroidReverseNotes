package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p209c.C41915j;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.pluginsdk.ui.l */
public final class C14949l {
    private static C4993ae<String, Integer> vjp = new C4993ae(50);
    private Context mContext;
    private StringBuilder vjh;
    private SpannableStringBuilder vji = new SpannableStringBuilder();
    private SpannableString vjj;
    private SpannableStringBuilder vjk = new SpannableStringBuilder();
    private CharacterStyle vjl = new ForegroundColorSpan(-5066062);
    private int vjm;
    private int vjn;
    public int vjo = 3;

    public C14949l(Context context) {
        AppMethodBeat.m2504i(27572);
        this.mContext = context;
        AppMethodBeat.m2505o(27572);
    }

    /* renamed from: a */
    public final void mo27296a(MMEditText mMEditText, String str, boolean z) {
        AppMethodBeat.m2504i(27573);
        if (mMEditText == null) {
            AppMethodBeat.m2505o(27573);
        } else if (this.vjh == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should saveHistory before setText");
            AppMethodBeat.m2505o(27573);
            throw illegalStateException;
        } else {
            int length = this.vjm + str.length();
            this.vji.clear();
            this.vjk.clear();
            if (z) {
                CharSequence charSequence;
                this.vjj = C9212g.dqQ().mo20622b(this.vjh.subSequence(0, this.vjm), mMEditText.getTextSize());
                SpannableStringBuilder append = this.vji.append(this.vjj);
                SpannableStringBuilder spannableStringBuilder = this.vjk;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length2;
                    int i;
                    if (str.length() < this.vjo) {
                        length2 = str.length();
                        i = 0;
                    } else {
                        length2 = str.length();
                        i = length2 - this.vjo;
                    }
                    spannableStringBuilder.append(str).setSpan(this.vjl, i, length2, 33);
                    Object charSequence2 = spannableStringBuilder;
                }
                append.append(charSequence2).append(this.vjh.subSequence(this.vjn, this.vjh.length()));
            } else {
                this.vjj = C9212g.dqQ().mo20622b(str, mMEditText.getTextSize());
                this.vji.append(this.vjj);
            }
            C4990ab.m7411d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.vjm), Integer.valueOf(this.vjn), Integer.valueOf(length), Integer.valueOf(this.vji.length()), str, this.vji);
            mMEditText.setText(this.vji);
            if (length <= this.vji.length()) {
                if (length == 0) {
                    mMEditText.setSelection(this.vji.length());
                    AppMethodBeat.m2505o(27573);
                    return;
                }
                mMEditText.setSelection(length);
            }
            AppMethodBeat.m2505o(27573);
        }
    }

    /* renamed from: a */
    public final void mo27295a(MMEditText mMEditText) {
        AppMethodBeat.m2504i(27574);
        if (mMEditText == null) {
            AppMethodBeat.m2505o(27574);
            return;
        }
        this.vjo = 0;
        this.vjj = C9212g.dqQ().mo20622b(mMEditText.getText().toString(), mMEditText.getTextSize());
        C4990ab.m7411d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.vjj);
        mMEditText.setText(this.vjj);
        mMEditText.setSelection(this.vjj.length());
        AppMethodBeat.m2505o(27574);
    }

    /* renamed from: b */
    public final void mo27298b(MMEditText mMEditText) {
        AppMethodBeat.m2504i(27575);
        if (mMEditText == null) {
            AppMethodBeat.m2505o(27575);
            return;
        }
        this.vjm = mMEditText.getSelectionStart();
        this.vjn = mMEditText.getSelectionEnd();
        this.vjh = new StringBuilder(mMEditText.getText());
        C4990ab.m7411d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.vjm), Integer.valueOf(this.vjn), this.vjh);
        if (mMEditText.getText().toString().equalsIgnoreCase("")) {
            this.vji.clear();
        }
        AppMethodBeat.m2505o(27575);
    }

    static {
        AppMethodBeat.m2504i(27578);
        AppMethodBeat.m2505o(27578);
    }

    public final synchronized int aju(String str) {
        int intValue;
        AppMethodBeat.m2504i(27576);
        if (vjp.size() == 0) {
            try {
                for (String split : ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, (Object) "")).split(";")) {
                    String[] split2 = split.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    if (split2.length == 2) {
                        vjp.put(split2[0], Integer.valueOf(C41915j.getInt(split2[1], 0)));
                    }
                }
            } catch (Error e) {
            }
        }
        if (vjp.mo10274aj(str)) {
            intValue = ((Integer) vjp.get(str)).intValue();
            AppMethodBeat.m2505o(27576);
        } else {
            AppMethodBeat.m2505o(27576);
            intValue = 0;
        }
        return intValue;
    }

    /* renamed from: ea */
    public final synchronized void mo27299ea(String str, int i) {
        AppMethodBeat.m2504i(27577);
        vjp.put(str, Integer.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        Object[] toArray = vjp.map.keySet().toArray();
        Object[] toArray2 = vjp.map.values().toArray();
        for (int i2 = 0; i2 < toArray.length; i2++) {
            stringBuilder.append(toArray[i2]).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(toArray2[i2]).append(";");
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, stringBuilder.toString());
        AppMethodBeat.m2505o(27577);
    }
}
