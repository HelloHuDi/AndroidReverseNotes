package com.tencent.p177mm.plugin.story.p536ui.view.editor.item;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.editor.p252a.C18589i;
import com.tencent.p177mm.media.editor.p252a.C37889e;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u001e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "TAG", "", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "reportPositionString", "Ljava/lang/StringBuffer;", "getReportPositionString", "()Ljava/lang/StringBuffer;", "setReportPositionString", "(Ljava/lang/StringBuffer;)V", "createPositionBitmap", "Landroid/graphics/Bitmap;", "cityName", "poiName", "createReportString", "", "city", "reshowPosition", "matrix", "Landroid/graphics/Matrix;", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.e */
public final class C46289e extends C13878a {
    private final String TAG = "MicroMsg.PositionItemView";
    private float cEB;
    private float cGm;
    private final int jka = -1;
    private final int snk = -1;
    private StringBuffer snl = new StringBuffer();

    public C46289e(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110692);
        AppMethodBeat.m2505o(110692);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.m2504i(110687);
        C25052j.m39376p(rect, "validRect");
        getTouchTracker().aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * 0.7f);
        AppMethodBeat.m2505o(110687);
    }

    /* renamed from: a */
    public final void mo74443a(String str, String str2, Matrix matrix) {
        AppMethodBeat.m2504i(110688);
        C25052j.m39376p(str, "cityName");
        C25052j.m39376p(str2, "poiName");
        C25052j.m39376p(matrix, "matrix");
        mo74444gD(str, str2);
        setViewMatrix(matrix);
        setSourceDataType(C37889e.LOCATION);
        AppMethodBeat.m2505o(110688);
    }

    /* renamed from: gD */
    public final Bitmap mo74444gD(String str, String str2) {
        AppMethodBeat.m2504i(110689);
        C25052j.m39376p(str, "cityName");
        C25052j.m39376p(str2, "poiName");
        View inflate = LayoutInflater.from(getContext()).inflate(2130970876, new LinearLayout(getContext()), false);
        TextView textView = (TextView) inflate.findViewById(2131828099);
        TextView textView2 = (TextView) inflate.findViewById(2131828100);
        C25052j.m39375o(textView, "cityText");
        C8902b.m16047f(textView);
        C25052j.m39375o(textView2, "poiText");
        C8902b.m16047f(textView2);
        textView.setText(str);
        textView2.setText(str2);
        if (TextUtils.isEmpty(C31820v.trim(str2).toString())) {
            textView.setTextSize(0, (float) C42677e.m75581c(getContext(), 20.0f));
            textView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(C31820v.trim(str).toString())) {
            textView2.setTextSize(0, (float) C42677e.m75581c(getContext(), 20.0f));
            textView.setVisibility(8);
        }
        inflate.measure(0, 0);
        C25052j.m39375o(inflate, "parent");
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        C4990ab.m7416i(this.TAG, "cityName : " + str + ", poiName : " + str2 + " parent.measuredWidth:" + inflate.getMeasuredWidth() + " , parent.measuredHeight:" + inflate.getMeasuredHeight());
        int measuredWidth = inflate.getMeasuredWidth();
        C22210l c22210l = C22210l.sac;
        if (measuredWidth > C22210l.czI().width()) {
            C22210l c22210l2 = C22210l.sac;
            measuredWidth = C22210l.czI().width();
        } else {
            measuredWidth = inflate.getMeasuredWidth();
        }
        int measuredHeight = inflate.getMeasuredHeight();
        C22210l c22210l3 = C22210l.sac;
        if (measuredHeight > C22210l.czI().height()) {
            c22210l = C22210l.sac;
            measuredHeight = C22210l.czI().height();
        } else {
            measuredHeight = inflate.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
        inflate.draw(new Canvas(createBitmap));
        setColor(this.snk);
        setTextBg(this.jka);
        setSourceDataType(C37889e.LOCATION);
        setLocation(new C18589i(str, str2));
        setBitmap(createBitmap);
        C25052j.m39375o(createBitmap, "bitmap");
        AppMethodBeat.m2505o(110689);
        return createBitmap;
    }

    public final void setLocation(cei cei) {
        AppMethodBeat.m2504i(110690);
        C25052j.m39376p(cei, C8741b.LOCATION);
        String str = cei.guP;
        C25052j.m39375o(str, "location.City");
        String str2 = cei.eUu;
        C25052j.m39375o(str2, "location.poiName");
        mo74444gD(str, str2);
        str2 = cei.guP;
        C25052j.m39375o(str2, "location.City");
        String str3 = cei.eUu;
        C25052j.m39375o(str3, "location.poiName");
        this.snl.setLength(0);
        if (!TextUtils.isEmpty(str2)) {
            this.snl.append(C6163u.m9838i(str2, ",", " ", true));
        }
        if (!TextUtils.isEmpty(str3)) {
            if (((CharSequence) this.snl).length() > 0) {
                this.snl.append("|");
            }
            this.snl.append(C6163u.m9838i(str3, ",", " ", true));
        }
        this.cGm = cei.vRp;
        this.cEB = cei.vRq;
        AppMethodBeat.m2505o(110690);
    }

    public final StringBuffer getReportPositionString() {
        return this.snl;
    }

    public final void setReportPositionString(StringBuffer stringBuffer) {
        AppMethodBeat.m2504i(110691);
        C25052j.m39376p(stringBuffer, "<set-?>");
        this.snl = stringBuffer;
        AppMethodBeat.m2505o(110691);
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
