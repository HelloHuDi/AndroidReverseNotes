package com.tencent.ttpic.particlesystem2d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.model.WMGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ParticleItem {
    private static final String TAG = ParticleItem.class.getSimpleName();
    private TreeSet<Integer> activeWMGroupIndiesSet = new TreeSet();
    public boolean canUpdateTexture = true;
    public int clearMode;
    public int curRepeatCount = 0;
    public int curTexture;
    public int curWMGroupId;
    public int emissionMode;
    public float emitterX;
    public float emitterY;
    private TreeSet<Integer> idleWMGroupIndiesSet = new TreeSet();
    public boolean lastFrameParticleReachMax;
    public long lastUpdateTimestamp;
    public List<WMGroup> lockedWMGroups = new ArrayList();
    public int maxRepeatCount = 1;
    public int minUpdateInterval;
    public boolean particleAlwaysUpdate;
    public boolean particleReachMax;
    public Particle[] particles;
    public float screenRatioScale = 1.0f;
    public StickerItem stickerItem;
    public boolean takenByParticle = false;
    public boolean textureUpdated;
    public TriggerCtrlItem triggerCtrlItem;
    public boolean triggered;
    public int updateCount = 0;

    static {
        AppMethodBeat.i(83649);
        AppMethodBeat.o(83649);
    }

    public ParticleItem(StickerItem stickerItem) {
        AppMethodBeat.i(83641);
        this.stickerItem = stickerItem;
        initIdleWMGroupIndiesSet();
        AppMethodBeat.o(83641);
    }

    private void initIdleWMGroupIndiesSet() {
        AppMethodBeat.i(83642);
        for (int i = 0; i < this.stickerItem.wmGroupCopies.size(); i++) {
            this.idleWMGroupIndiesSet.add(Integer.valueOf(i));
        }
        AppMethodBeat.o(83642);
    }

    public WMGroup getAvailableWMGroup() {
        AppMethodBeat.i(83643);
        if (this.idleWMGroupIndiesSet.isEmpty()) {
            AppMethodBeat.o(83643);
            return null;
        }
        WMGroup wMGroup = (WMGroup) this.stickerItem.wmGroupCopies.get(((Integer) this.idleWMGroupIndiesSet.pollFirst()).intValue());
        AppMethodBeat.o(83643);
        return wMGroup;
    }

    public void useWMGroup(int i) {
        AppMethodBeat.i(83644);
        this.idleWMGroupIndiesSet.remove(Integer.valueOf(i));
        this.activeWMGroupIndiesSet.add(Integer.valueOf(i));
        AppMethodBeat.o(83644);
    }

    public List<WMGroup> getActiveWMGroups() {
        AppMethodBeat.i(83645);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.activeWMGroupIndiesSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (((WMGroup) this.stickerItem.wmGroupCopies.get(intValue)).isAsyncDrawFinished()) {
                arrayList.add(this.stickerItem.wmGroupCopies.get(intValue));
            }
        }
        AppMethodBeat.o(83645);
        return arrayList;
    }

    public void recycleWMGroup(int i) {
        AppMethodBeat.i(83646);
        this.idleWMGroupIndiesSet.add(Integer.valueOf(i));
        this.activeWMGroupIndiesSet.remove(Integer.valueOf(i));
        ((WMGroup) this.stickerItem.wmGroupCopies.get(i)).reset();
        AppMethodBeat.o(83646);
    }

    public void reset() {
        AppMethodBeat.i(83647);
        this.particleReachMax = false;
        this.lastFrameParticleReachMax = false;
        this.canUpdateTexture = true;
        this.curRepeatCount = 0;
        this.curTexture = 0;
        this.triggered = false;
        if (this.particles != null) {
            for (Particle particle : this.particles) {
                particle.alive = false;
                particle.texture = 0;
            }
        }
        resetWMGroup();
        AppMethodBeat.o(83647);
    }

    public void resetWMGroup() {
        AppMethodBeat.i(83648);
        this.idleWMGroupIndiesSet.clear();
        this.activeWMGroupIndiesSet.clear();
        initIdleWMGroupIndiesSet();
        if (this.stickerItem.wmGroupCopies != null) {
            for (WMGroup wMGroup : this.stickerItem.wmGroupCopies) {
                wMGroup.unlock();
                wMGroup.reset();
            }
        }
        AppMethodBeat.o(83648);
    }
}
