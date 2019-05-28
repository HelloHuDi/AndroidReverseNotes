package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.api.AbsStoryMuteView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryMuteView */
public final class StoryMuteView extends AbsStoryMuteView {
    private final int sjU = 30;
    private final int sjV;
    private Drawable sjW;
    private TextView sjX;
    private ImageView sjY;

    public StoryMuteView(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110446);
        cCp();
        AppMethodBeat.m2505o(110446);
    }

    public StoryMuteView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110447);
        cCp();
        AppMethodBeat.m2505o(110447);
    }

    public StoryMuteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110448);
        cCp();
        AppMethodBeat.m2505o(110448);
    }

    private final void cCp() {
        AppMethodBeat.m2504i(110441);
        LayoutInflater.from(getContext()).inflate(2130970897, this);
        this.sjX = (TextView) findViewById(2131828177);
        this.sjY = (ImageView) findViewById(2131828176);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.sjW = C5225ah.m7961e(context.getResources().getDrawable(C1318a.icons_outlined_volume_off), -1);
        Drawable drawable = this.sjW;
        if (drawable == null) {
            C25052j.dWJ();
        }
        drawable.setBounds(0, 0, C1338a.fromDPToPix(getContext(), 48), C1338a.fromDPToPix(getContext(), 48));
        TextView textView = this.sjX;
        if (textView != null) {
            textView.setCompoundDrawables(null, this.sjW, null, null);
        }
        TextView textView2 = this.sjX;
        if (textView2 != null) {
            context = getContext();
            C25052j.m39375o(context, "context");
            textView2.setText(context.getResources().getString(C25738R.string.et3));
        }
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjU, this.sjU, this.sjV);
            AppMethodBeat.m2505o(110441);
            return;
        }
        AppMethodBeat.m2505o(110441);
    }

    /* renamed from: fO */
    private static int m6491fO(int i, int i2) {
        AppMethodBeat.m2504i(110442);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode == ErrorDialogData.SUPPRESSED) {
            i = size;
        } else if (mode == C8415j.INVALID_ID) {
            i = Math.min(i, size);
        }
        AppMethodBeat.m2505o(110442);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(110443);
        int fO = StoryMuteView.m6491fO(C1338a.m2857am(getContext(), C25738R.dimen.a7g), i);
        int fO2 = StoryMuteView.m6491fO(C1338a.m2857am(getContext(), C25738R.dimen.a7g), i2);
        super.onMeasure(i, i2);
        setMeasuredDimension(fO, fO2);
        AppMethodBeat.m2505o(110443);
    }

    public final void cwM() {
        AppMethodBeat.m2504i(110444);
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjV, this.sjV, this.sjV);
            AppMethodBeat.m2505o(110444);
            return;
        }
        AppMethodBeat.m2505o(110444);
    }

    public final void cwN() {
        AppMethodBeat.m2504i(110445);
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjU, this.sjU, this.sjV);
            AppMethodBeat.m2505o(110445);
            return;
        }
        AppMethodBeat.m2505o(110445);
    }
}
