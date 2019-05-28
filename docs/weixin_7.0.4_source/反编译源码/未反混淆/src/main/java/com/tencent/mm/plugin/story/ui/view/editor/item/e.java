package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.k.u;
import a.k.v;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u001e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "TAG", "", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "reportPositionString", "Ljava/lang/StringBuffer;", "getReportPositionString", "()Ljava/lang/StringBuffer;", "setReportPositionString", "(Ljava/lang/StringBuffer;)V", "createPositionBitmap", "Landroid/graphics/Bitmap;", "cityName", "poiName", "createReportString", "", "city", "reshowPosition", "matrix", "Landroid/graphics/Matrix;", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-story_release"})
public final class e extends a {
    private final String TAG = "MicroMsg.PositionItemView";
    private float cEB;
    private float cGm;
    private final int jka = -1;
    private final int snk = -1;
    private StringBuffer snl = new StringBuffer();

    public e(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110692);
        AppMethodBeat.o(110692);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(110687);
        j.p(rect, "validRect");
        getTouchTracker().aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * 0.7f);
        AppMethodBeat.o(110687);
    }

    public final void a(String str, String str2, Matrix matrix) {
        AppMethodBeat.i(110688);
        j.p(str, "cityName");
        j.p(str2, "poiName");
        j.p(matrix, "matrix");
        gD(str, str2);
        setViewMatrix(matrix);
        setSourceDataType(com.tencent.mm.media.editor.a.e.LOCATION);
        AppMethodBeat.o(110688);
    }

    public final Bitmap gD(String str, String str2) {
        AppMethodBeat.i(110689);
        j.p(str, "cityName");
        j.p(str2, "poiName");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ayc, new LinearLayout(getContext()), false);
        TextView textView = (TextView) inflate.findViewById(R.id.es8);
        TextView textView2 = (TextView) inflate.findViewById(R.id.es9);
        j.o(textView, "cityText");
        b.f(textView);
        j.o(textView2, "poiText");
        b.f(textView2);
        textView.setText(str);
        textView2.setText(str2);
        if (TextUtils.isEmpty(v.trim(str2).toString())) {
            textView.setTextSize(0, (float) com.tencent.mm.plugin.appbrand.s.e.c(getContext(), 20.0f));
            textView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(v.trim(str).toString())) {
            textView2.setTextSize(0, (float) com.tencent.mm.plugin.appbrand.s.e.c(getContext(), 20.0f));
            textView.setVisibility(8);
        }
        inflate.measure(0, 0);
        j.o(inflate, "parent");
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        ab.i(this.TAG, "cityName : " + str + ", poiName : " + str2 + " parent.measuredWidth:" + inflate.getMeasuredWidth() + " , parent.measuredHeight:" + inflate.getMeasuredHeight());
        int measuredWidth = inflate.getMeasuredWidth();
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        if (measuredWidth > com.tencent.mm.plugin.story.f.l.czI().width()) {
            com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.sac;
            measuredWidth = com.tencent.mm.plugin.story.f.l.czI().width();
        } else {
            measuredWidth = inflate.getMeasuredWidth();
        }
        int measuredHeight = inflate.getMeasuredHeight();
        com.tencent.mm.plugin.story.f.l lVar3 = com.tencent.mm.plugin.story.f.l.sac;
        if (measuredHeight > com.tencent.mm.plugin.story.f.l.czI().height()) {
            lVar = com.tencent.mm.plugin.story.f.l.sac;
            measuredHeight = com.tencent.mm.plugin.story.f.l.czI().height();
        } else {
            measuredHeight = inflate.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
        inflate.draw(new Canvas(createBitmap));
        setColor(this.snk);
        setTextBg(this.jka);
        setSourceDataType(com.tencent.mm.media.editor.a.e.LOCATION);
        setLocation(new i(str, str2));
        setBitmap(createBitmap);
        j.o(createBitmap, "bitmap");
        AppMethodBeat.o(110689);
        return createBitmap;
    }

    public final void setLocation(cei cei) {
        AppMethodBeat.i(110690);
        j.p(cei, FirebaseAnalytics.b.LOCATION);
        String str = cei.guP;
        j.o(str, "location.City");
        String str2 = cei.eUu;
        j.o(str2, "location.poiName");
        gD(str, str2);
        str2 = cei.guP;
        j.o(str2, "location.City");
        String str3 = cei.eUu;
        j.o(str3, "location.poiName");
        this.snl.setLength(0);
        if (!TextUtils.isEmpty(str2)) {
            this.snl.append(u.i(str2, ",", " ", true));
        }
        if (!TextUtils.isEmpty(str3)) {
            if (((CharSequence) this.snl).length() > 0) {
                this.snl.append("|");
            }
            this.snl.append(u.i(str3, ",", " ", true));
        }
        this.cGm = cei.vRp;
        this.cEB = cei.vRq;
        AppMethodBeat.o(110690);
    }

    public final StringBuffer getReportPositionString() {
        return this.snl;
    }

    public final void setReportPositionString(StringBuffer stringBuffer) {
        AppMethodBeat.i(110691);
        j.p(stringBuffer, "<set-?>");
        this.snl = stringBuffer;
        AppMethodBeat.o(110691);
    }

    public final float getLongitude() {
        return this.cGm;
    }

    public final void setLongitude(float f) {
        this.cGm = f;
    }

    public final float getLatitude() {
        return this.cEB;
    }

    public final void setLatitude(float f) {
        this.cEB = f;
    }
}
