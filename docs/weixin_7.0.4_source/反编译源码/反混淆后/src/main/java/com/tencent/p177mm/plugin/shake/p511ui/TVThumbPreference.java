package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.plugin.shake.p1296e.C29004b;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.ui.TVThumbPreference */
public class TVThumbPreference extends Preference implements C18765a {
    C15541f iFE;
    private ImageView qwI;
    private ImageView qwJ;
    private ImageView qwK;
    List<String> qwL;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(24939);
        this.qwL = null;
        setLayoutResource(2130970974);
        setWidgetLayoutResource(0);
        C18764x.m29326a((C18765a) this);
        AppMethodBeat.m2505o(24939);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(24940);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.m2505o(24940);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(24941);
        super.onBindView(view);
        this.qwI = (ImageView) view.findViewById(2131828371);
        this.qwJ = (ImageView) view.findViewById(2131828372);
        this.qwK = (ImageView) view.findViewById(2131828373);
        if (this.qwL != null) {
            if (this.qwL.size() <= 0) {
                AppMethodBeat.m2505o(24941);
                return;
            }
            C9791v c29004b = new C29004b((String) this.qwL.get(0));
            this.qwI.setTag(c29004b.anL());
            Bitmap a = C18764x.m29325a(c29004b);
            if (!(a == null || a.isRecycled())) {
                this.qwI.setImageBitmap(a);
            }
            this.qwI.setVisibility(0);
            if (1 >= this.qwL.size()) {
                AppMethodBeat.m2505o(24941);
                return;
            }
            c29004b = new C29004b((String) this.qwL.get(1));
            this.qwJ.setTag(c29004b.anL());
            a = C18764x.m29325a(c29004b);
            if (!(a == null || a.isRecycled())) {
                this.qwJ.setImageBitmap(a);
            }
            this.qwJ.setVisibility(0);
            if (2 >= this.qwL.size()) {
                AppMethodBeat.m2505o(24941);
                return;
            }
            c29004b = new C29004b((String) this.qwL.get(2));
            this.qwK.setTag(c29004b.anL());
            a = C18764x.m29325a(c29004b);
            if (!(a == null || a.isRecycled())) {
                this.qwK.setImageBitmap(a);
            }
            this.qwK.setVisibility(0);
        }
        AppMethodBeat.m2505o(24941);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(24942);
        if (str == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(24942);
        } else if (this.qwI != null && this.qwI.getTag() != null && str.equals((String) this.qwI.getTag())) {
            this.qwI.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24936);
                    TVThumbPreference.this.qwI.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.iFE != null) {
                        TVThumbPreference.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(24936);
                }
            });
            AppMethodBeat.m2505o(24942);
        } else if (this.qwJ == null || this.qwJ.getTag() == null || !str.equals((String) this.qwJ.getTag())) {
            if (!(this.qwK == null || this.qwK.getTag() == null || !str.equals((String) this.qwK.getTag()))) {
                this.qwK.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(24938);
                        TVThumbPreference.this.qwK.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.iFE != null) {
                            TVThumbPreference.this.iFE.notifyDataSetChanged();
                        }
                        AppMethodBeat.m2505o(24938);
                    }
                });
            }
            AppMethodBeat.m2505o(24942);
        } else {
            this.qwJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24937);
                    TVThumbPreference.this.qwJ.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.iFE != null) {
                        TVThumbPreference.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(24937);
                }
            });
            AppMethodBeat.m2505o(24942);
        }
    }
}
