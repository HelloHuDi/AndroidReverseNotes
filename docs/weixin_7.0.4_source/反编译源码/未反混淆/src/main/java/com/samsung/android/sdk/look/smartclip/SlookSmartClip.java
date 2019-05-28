package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.samsung.android.smartclip.SmartClipMetaUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookSmartClip {
    private static final String TAG = "SmartClip";
    private DataExtractionListener mDataExtractionListener = null;
    private Slook mSlook = new Slook();
    private View mView = null;

    public interface DataExtractionListener {
        public static final int EXTRACTION_DEFAULT = 1;
        public static final int EXTRACTION_DISCARD = 0;

        int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea);
    }

    public SlookSmartClip(View view) {
        AppMethodBeat.i(117214);
        this.mView = view;
        AppMethodBeat.o(117214);
    }

    public final void addMetaTag(SlookSmartClipMetaTag slookSmartClipMetaTag) {
        AppMethodBeat.i(117215);
        if (isSupport(1)) {
            SmartClipMetaUtils.addMetaTag(this.mView, slookSmartClipMetaTag);
            AppMethodBeat.o(117215);
            return;
        }
        AppMethodBeat.o(117215);
    }

    public final void removeMetaTag(String str) {
        AppMethodBeat.i(117216);
        if (isSupport(1)) {
            SmartClipMetaUtils.removeMetaTag(this.mView, str);
            AppMethodBeat.o(117216);
            return;
        }
        AppMethodBeat.o(117216);
    }

    public final void clearAllMetaTag() {
        AppMethodBeat.i(117217);
        if (isSupport(1)) {
            SmartClipMetaUtils.clearAllMetaTag(this.mView);
            AppMethodBeat.o(117217);
            return;
        }
        AppMethodBeat.o(117217);
    }

    public final void setDataExtractionListener(DataExtractionListener dataExtractionListener) {
        AppMethodBeat.i(117218);
        if (isSupport(1)) {
            this.mDataExtractionListener = dataExtractionListener;
            SmartClipMetaUtils.setDataExtractionListener(this.mView, new SmartClipDataExtractionListener() {
                public int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
                    AppMethodBeat.i(117213);
                    int onExtractSmartClipData = SlookSmartClip.this.mDataExtractionListener.onExtractSmartClipData(view, slookSmartClipDataElement, slookSmartClipCroppedArea);
                    AppMethodBeat.o(117213);
                    return onExtractSmartClipData;
                }
            });
            AppMethodBeat.o(117218);
            return;
        }
        AppMethodBeat.o(117218);
    }

    public final int extractDefaultSmartClipData(SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
        AppMethodBeat.i(117219);
        if (isSupport(1)) {
            int extractDefaultSmartClipData = SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, slookSmartClipDataElement, slookSmartClipCroppedArea);
            AppMethodBeat.o(117219);
            return extractDefaultSmartClipData;
        }
        AppMethodBeat.o(117219);
        return 0;
    }

    private boolean isSupport(int i) {
        AppMethodBeat.i(117220);
        if (this.mSlook.isFeatureEnabled(2)) {
            AppMethodBeat.o(117220);
            return true;
        }
        AppMethodBeat.o(117220);
        return false;
    }
}
