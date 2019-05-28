package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.j;
import com.tencent.mm.cb.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class l {
    private static ae<String, Integer> vjp = new ae(50);
    private Context mContext;
    private StringBuilder vjh;
    private SpannableStringBuilder vji = new SpannableStringBuilder();
    private SpannableString vjj;
    private SpannableStringBuilder vjk = new SpannableStringBuilder();
    private CharacterStyle vjl = new ForegroundColorSpan(-5066062);
    private int vjm;
    private int vjn;
    public int vjo = 3;

    public l(Context context) {
        AppMethodBeat.i(27572);
        this.mContext = context;
        AppMethodBeat.o(27572);
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        AppMethodBeat.i(27573);
        if (mMEditText == null) {
            AppMethodBeat.o(27573);
        } else if (this.vjh == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should saveHistory before setText");
            AppMethodBeat.o(27573);
            throw illegalStateException;
        } else {
            int length = this.vjm + str.length();
            this.vji.clear();
            this.vjk.clear();
            if (z) {
                CharSequence charSequence;
                this.vjj = g.dqQ().b(this.vjh.subSequence(0, this.vjm), mMEditText.getTextSize());
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
                this.vjj = g.dqQ().b(str, mMEditText.getTextSize());
                this.vji.append(this.vjj);
            }
            ab.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.vjm), Integer.valueOf(this.vjn), Integer.valueOf(length), Integer.valueOf(this.vji.length()), str, this.vji);
            mMEditText.setText(this.vji);
            if (length <= this.vji.length()) {
                if (length == 0) {
                    mMEditText.setSelection(this.vji.length());
                    AppMethodBeat.o(27573);
                    return;
                }
                mMEditText.setSelection(length);
            }
            AppMethodBeat.o(27573);
        }
    }

    public final void a(MMEditText mMEditText) {
        AppMethodBeat.i(27574);
        if (mMEditText == null) {
            AppMethodBeat.o(27574);
            return;
        }
        this.vjo = 0;
        this.vjj = g.dqQ().b(mMEditText.getText().toString(), mMEditText.getTextSize());
        ab.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.vjj);
        mMEditText.setText(this.vjj);
        mMEditText.setSelection(this.vjj.length());
        AppMethodBeat.o(27574);
    }

    public final void b(MMEditText mMEditText) {
        AppMethodBeat.i(27575);
        if (mMEditText == null) {
            AppMethodBeat.o(27575);
            return;
        }
        this.vjm = mMEditText.getSelectionStart();
        this.vjn = mMEditText.getSelectionEnd();
        this.vjh = new StringBuilder(mMEditText.getText());
        ab.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.vjm), Integer.valueOf(this.vjn), this.vjh);
        if (mMEditText.getText().toString().equalsIgnoreCase("")) {
            this.vji.clear();
        }
        AppMethodBeat.o(27575);
    }

    static {
        AppMethodBeat.i(27578);
        AppMethodBeat.o(27578);
    }

    public final synchronized int aju(String str) {
        int intValue;
        AppMethodBeat.i(27576);
        if (vjp.size() == 0) {
            try {
                for (String split : ((String) com.tencent.mm.kernel.g.RP().Ry().get(a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, (Object) "")).split(";")) {
                    String[] split2 = split.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    if (split2.length == 2) {
                        vjp.put(split2[0], Integer.valueOf(j.getInt(split2[1], 0)));
                    }
                }
            } catch (Error e) {
            }
        }
        if (vjp.aj(str)) {
            intValue = ((Integer) vjp.get(str)).intValue();
            AppMethodBeat.o(27576);
        } else {
            AppMethodBeat.o(27576);
            intValue = 0;
        }
        return intValue;
    }

    public final synchronized void ea(String str, int i) {
        AppMethodBeat.i(27577);
        vjp.put(str, Integer.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        Object[] toArray = vjp.map.keySet().toArray();
        Object[] toArray2 = vjp.map.values().toArray();
        for (int i2 = 0; i2 < toArray.length; i2++) {
            stringBuilder.append(toArray[i2]).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(toArray2[i2]).append(";");
        }
        com.tencent.mm.kernel.g.RP().Ry().set(a.USERINOF_VOICE_INPUT_DEF_LANG_HISTORY_STRING, stringBuilder.toString());
        AppMethodBeat.o(27577);
    }
}
