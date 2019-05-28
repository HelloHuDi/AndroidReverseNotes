package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public Typeface bTq = null;
    public Alignment eNC = Alignment.ALIGN_NORMAL;
    public TruncateAt eND = null;
    public TextDirectionHeuristic eNF = null;
    public float eNG = 0.0f;
    public float eNH = 1.0f;
    public boolean eNI = false;
    public TextPaint eNN = null;
    public int eOf = -1;
    public float eOg = -1.0f;
    public int fontStyle = -1;
    public int gravity = 51;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        AppMethodBeat.i(105814);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.eNN}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.eNC}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.eND}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.eOf)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.eNF}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.eNG), Float.valueOf(this.eNH)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.eNI)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.bTq}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.fontStyle)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.eOg)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(105814);
        return stringBuilder2;
    }

    public final int hashCode() {
        AppMethodBeat.i(105815);
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.eNN != null) {
            i += this.eNN.hashCode() * 31;
        }
        i += this.eNC.hashCode() * 31;
        if (this.eND != null) {
            i += this.eND.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.eOf * 31);
        if (this.eNF != null) {
            i += this.eNF.hashCode() * 31;
        }
        i = ((this.eNI ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.eNG * 31.0f)))) + (this.eNH * 31.0f)));
        if (this.bTq != null) {
            i += this.bTq.hashCode() * 31;
        }
        i = (((int) (((float) (i + (this.fontStyle * 31))) + (this.eOg * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
        AppMethodBeat.o(105815);
        return i;
    }
}
