package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardCdnImageView;", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "plugin-card_release"})
public final class CardCdnImageView extends CdnImageView {
    public CardCdnImageView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(89176);
        init();
        AppMethodBeat.o(89176);
    }

    public CardCdnImageView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(89177);
        init();
        AppMethodBeat.o(89177);
    }

    private final void init() {
        AppMethodBeat.i(89175);
        setUseSdcardCache(true);
        setImgSavedPath(m.kdH + "/");
        AppMethodBeat.o(89175);
    }
}
