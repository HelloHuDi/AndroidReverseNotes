package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuGridView */
public class LuGridView extends GridView {
    private ArrayList<Object> oiP = new ArrayList();

    public LuGridView(Context context) {
        super(context);
        AppMethodBeat.m2504i(116846);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(116846);
    }

    public LuGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116847);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(116847);
    }

    public LuGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(116848);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(116848);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        AppMethodBeat.m2504i(116849);
        if (VERSION.SDK_INT >= 11) {
            i = super.getNumColumns();
            AppMethodBeat.m2505o(116849);
            return i;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            i = declaredField.getInt(this);
            AppMethodBeat.m2505o(116849);
            return i;
        } catch (Exception e) {
            AppMethodBeat.m2505o(116849);
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public int getHeaderViewCount() {
        AppMethodBeat.m2504i(116850);
        int size = this.oiP.size();
        AppMethodBeat.m2505o(116850);
        return size;
    }
}
