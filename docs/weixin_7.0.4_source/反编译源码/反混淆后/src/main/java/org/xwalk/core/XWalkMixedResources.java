package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XWalkMixedResources extends Resources {
    private Resources mLibraryResource;

    private boolean isCalledInLibrary() {
        AppMethodBeat.m2504i(85702);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            String className = stackTrace[i].getClassName();
            if (className.startsWith("org.chromium") || className.startsWith("org.xwalk.core.internal")) {
                AppMethodBeat.m2505o(85702);
                return true;
            } else if (!className.startsWith("org.xwalk.core") || className.endsWith("XWalkMixedResources")) {
                i++;
            } else {
                AppMethodBeat.m2505o(85702);
                return false;
            }
        }
        AppMethodBeat.m2505o(85702);
        return false;
    }

    XWalkMixedResources(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.m2504i(85703);
        this.mLibraryResource = resources2;
        AppMethodBeat.m2505o(85703);
    }

    public CharSequence getText(int i) {
        AppMethodBeat.m2504i(85704);
        Object isCalledInLibrary = isCalledInLibrary();
        CharSequence text;
        if (isCalledInLibrary != null) {
            try {
                text = this.mLibraryResource.getText(i);
                AppMethodBeat.m2505o(85704);
                return text;
            } catch (NotFoundException e) {
                if (isCalledInLibrary != null) {
                    text = super.getText(i);
                    AppMethodBeat.m2505o(85704);
                    return text;
                }
                text = this.mLibraryResource.getText(i);
                AppMethodBeat.m2505o(85704);
                return text;
            }
        }
        text = super.getText(i);
        AppMethodBeat.m2505o(85704);
        return text;
    }

    public XmlResourceParser getLayout(int i) {
        AppMethodBeat.m2504i(85705);
        Object isCalledInLibrary = isCalledInLibrary();
        XmlResourceParser layout;
        if (isCalledInLibrary != null) {
            try {
                layout = this.mLibraryResource.getLayout(i);
                AppMethodBeat.m2505o(85705);
                return layout;
            } catch (NotFoundException e) {
                if (isCalledInLibrary != null) {
                    layout = super.getLayout(i);
                    AppMethodBeat.m2505o(85705);
                    return layout;
                }
                layout = this.mLibraryResource.getLayout(i);
                AppMethodBeat.m2505o(85705);
                return layout;
            }
        }
        layout = super.getLayout(i);
        AppMethodBeat.m2505o(85705);
        return layout;
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        AppMethodBeat.m2504i(85706);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValue(i, typedValue, z);
                AppMethodBeat.m2505o(85706);
                return;
            } catch (NotFoundException e) {
                if (isCalledInLibrary) {
                    super.getValue(i, typedValue, z);
                    AppMethodBeat.m2505o(85706);
                    return;
                }
                this.mLibraryResource.getValue(i, typedValue, z);
                AppMethodBeat.m2505o(85706);
                return;
            }
        }
        super.getValue(i, typedValue, z);
        AppMethodBeat.m2505o(85706);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        AppMethodBeat.m2504i(85707);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValueForDensity(i, i2, typedValue, z);
                AppMethodBeat.m2505o(85707);
                return;
            } catch (NotFoundException e) {
                if (isCalledInLibrary) {
                    super.getValueForDensity(i, i2, typedValue, z);
                    AppMethodBeat.m2505o(85707);
                    return;
                }
                this.mLibraryResource.getValueForDensity(i, i2, typedValue, z);
                AppMethodBeat.m2505o(85707);
                return;
            }
        }
        super.getValueForDensity(i, i2, typedValue, z);
        AppMethodBeat.m2505o(85707);
    }

    public int getIdentifier(String str, String str2, String str3) {
        AppMethodBeat.m2504i(85708);
        int identifier;
        if (isCalledInLibrary()) {
            identifier = this.mLibraryResource.getIdentifier(str, str2, str3);
            if (identifier != 0) {
                AppMethodBeat.m2505o(85708);
                return identifier;
            }
            identifier = super.getIdentifier(str, str2, str3);
            AppMethodBeat.m2505o(85708);
            return identifier;
        }
        identifier = super.getIdentifier(str, str2, str3);
        if (identifier != 0) {
            AppMethodBeat.m2505o(85708);
            return identifier;
        }
        identifier = this.mLibraryResource.getIdentifier(str, str2, str3);
        AppMethodBeat.m2505o(85708);
        return identifier;
    }

    public Drawable getDrawable(int i) {
        AppMethodBeat.m2504i(85709);
        Object isCalledInLibrary = isCalledInLibrary();
        Drawable drawable;
        if (isCalledInLibrary != null) {
            try {
                drawable = this.mLibraryResource.getDrawable(i);
                AppMethodBeat.m2505o(85709);
                return drawable;
            } catch (NotFoundException e) {
                if (isCalledInLibrary != null) {
                    drawable = super.getDrawable(i);
                    AppMethodBeat.m2505o(85709);
                    return drawable;
                }
                drawable = this.mLibraryResource.getDrawable(i);
                AppMethodBeat.m2505o(85709);
                return drawable;
            }
        }
        drawable = super.getDrawable(i);
        AppMethodBeat.m2505o(85709);
        return drawable;
    }
}
