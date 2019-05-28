package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView extends AbsStoryMuteView {
    private final int sjU = 30;
    private final int sjV;
    private Drawable sjW;
    private TextView sjX;
    private ImageView sjY;

    public StoryMuteView(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110446);
        cCp();
        AppMethodBeat.o(110446);
    }

    public StoryMuteView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(110447);
        cCp();
        AppMethodBeat.o(110447);
    }

    public StoryMuteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(110448);
        cCp();
        AppMethodBeat.o(110448);
    }

    private final void cCp() {
        AppMethodBeat.i(110441);
        LayoutInflater.from(getContext()).inflate(R.layout.ayx, this);
        this.sjX = (TextView) findViewById(R.id.eub);
        this.sjY = (ImageView) findViewById(R.id.eua);
        Context context = getContext();
        j.o(context, "context");
        this.sjW = ah.e(context.getResources().getDrawable(R.raw.icons_outlined_volume_off), -1);
        Drawable drawable = this.sjW;
        if (drawable == null) {
            j.dWJ();
        }
        drawable.setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
        TextView textView = this.sjX;
        if (textView != null) {
            textView.setCompoundDrawables(null, this.sjW, null, null);
        }
        TextView textView2 = this.sjX;
        if (textView2 != null) {
            context = getContext();
            j.o(context, "context");
            textView2.setText(context.getResources().getString(R.string.et3));
        }
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjU, this.sjU, this.sjV);
            AppMethodBeat.o(110441);
            return;
        }
        AppMethodBeat.o(110441);
    }

    private static int fO(int i, int i2) {
        AppMethodBeat.i(110442);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode == ErrorDialogData.SUPPRESSED) {
            i = size;
        } else if (mode == android.support.v4.widget.j.INVALID_ID) {
            i = Math.min(i, size);
        }
        AppMethodBeat.o(110442);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(110443);
        int fO = fO(a.am(getContext(), R.dimen.a7g), i);
        int fO2 = fO(a.am(getContext(), R.dimen.a7g), i2);
        super.onMeasure(i, i2);
        setMeasuredDimension(fO, fO2);
        AppMethodBeat.o(110443);
    }

    public final void cwM() {
        AppMethodBeat.i(110444);
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjV, this.sjV, this.sjV);
            AppMethodBeat.o(110444);
            return;
        }
        AppMethodBeat.o(110444);
    }

    public final void cwN() {
        AppMethodBeat.i(110445);
        ImageView imageView = this.sjY;
        if (imageView != null) {
            imageView.setPadding(this.sjV, this.sjU, this.sjU, this.sjV);
            AppMethodBeat.o(110445);
            return;
        }
        AppMethodBeat.o(110445);
    }
}
