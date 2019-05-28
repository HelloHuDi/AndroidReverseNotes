package com.tencent.mm.plugin.emojicapture.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u00020(J\b\u00101\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "", "()V", "iconPath", "", "getIconPath", "()Ljava/lang/String;", "setIconPath", "(Ljava/lang/String;)V", "lensId", "getLensId", "setLensId", "name", "getName", "setName", "resPath", "getResPath", "setResPath", "subType", "", "getSubType", "()I", "setSubType", "(I)V", "tipIcons", "Ljava/util/LinkedList;", "getTipIcons", "()Ljava/util/LinkedList;", "setTipIcons", "(Ljava/util/LinkedList;)V", "tips", "getTips", "setTips", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "valid", "", "getValid", "()Z", "setValid", "(Z)V", "version", "getVersion", "setVersion", "isTipsValid", "toString", "plugin-emojicapture_release"})
public final class b {
    public boolean ajN;
    int cuu;
    public String fhL = "";
    public String hNN = "";
    public String kfM = "";
    public String lgY = "";
    public String lhL = "";
    public LinkedList<String> lhM = new LinkedList();
    public String name = "";
    public String title = "";
    int version;

    public b() {
        AppMethodBeat.i(2638);
        AppMethodBeat.o(2638);
    }

    public final String toString() {
        AppMethodBeat.i(2637);
        String str = "EmojiStickerInfo(subType=" + this.cuu + ", version=" + this.version + ", valid=" + this.ajN + ", lensId='" + this.lgY + "', iconPath='" + this.hNN + "', resPath='" + this.lhL + "', name='" + this.name + "', title='" + this.title + "', titleColor='" + this.fhL + "', tips='" + this.kfM + "', tipIcons=" + this.lhM + ')';
        AppMethodBeat.o(2637);
        return str;
    }
}
