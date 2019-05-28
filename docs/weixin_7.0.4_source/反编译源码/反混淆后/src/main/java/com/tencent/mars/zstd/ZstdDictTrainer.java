package com.tencent.mars.zstd;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZstdDictTrainer {
    private final int allocatedSize;
    private final int dictSize;
    private long filledSize;
    private final List<Integer> sampleSizes = new ArrayList();
    private final ByteBuffer trainingSamples;

    public ZstdDictTrainer(int i, int i2) {
        this.trainingSamples = ByteBuffer.allocateDirect(i);
        this.allocatedSize = i;
        this.dictSize = i2;
    }

    public boolean addSample(byte[] bArr) {
        if (this.filledSize + ((long) bArr.length) > ((long) this.allocatedSize)) {
            return false;
        }
        this.trainingSamples.put(bArr);
        this.sampleSizes.add(Integer.valueOf(bArr.length));
        this.filledSize += (long) bArr.length;
        return true;
    }

    public ByteBuffer trainSamplesDirect() {
        return trainSamplesDirect(false);
    }

    public ByteBuffer trainSamplesDirect(boolean z) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.dictSize);
        long trainFromBufferDirect = Zstd.trainFromBufferDirect(this.trainingSamples, copyToIntArray(this.sampleSizes), allocateDirect, z);
        if (Zstd.isError(trainFromBufferDirect)) {
            allocateDirect.limit(0);
            return null;
        }
        allocateDirect.limit(Long.valueOf(trainFromBufferDirect).intValue());
        return allocateDirect;
    }

    public byte[] trainSamples() {
        return trainSamples(false);
    }

    public byte[] trainSamples(boolean z) {
        ByteBuffer trainSamplesDirect = trainSamplesDirect(z);
        byte[] bArr = new byte[trainSamplesDirect.remaining()];
        trainSamplesDirect.get(bArr);
        return bArr;
    }

    private int[] copyToIntArray(List<Integer> list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            iArr[i2] = ((Integer) it.next()).intValue();
            i = i2 + 1;
        }
    }
}
