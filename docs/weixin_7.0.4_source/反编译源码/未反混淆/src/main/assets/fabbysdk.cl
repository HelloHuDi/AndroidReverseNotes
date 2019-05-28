const sampler_t sampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP | CLK_FILTER_LINEAR;

__kernel void CalcDiff(
    __global float* uData,
    __write_only image2d_t outputImage,
    int uniform_w,
    int uniform_h
    )
{
    int2 gid = (int2)(get_global_id(0), get_global_id(1));
    float width = (float)get_global_size(0);
        float height = (float)get_global_size(1);
        float posx = (float)gid.x * (float)uniform_w / width;
        float posy = (float)gid.y * (float)uniform_h / height;

        int dx = floor(posx);
        int dy = floor(posy);
        int dx2 = dx + 1;
        int dy2 = dy + 1;
        if (dx < 0) dx = 0;
        if (dy < 0) dy = 0;
        if (dx2 == uniform_w) dx2 = dx;
        if (dy2 == uniform_h) dy2 = dy;
        float ratioX = posx - dx;
        float ratioY = posy - dy;
        float u1 = uData[dx + dy * uniform_w];
        float u2 = uData[dx2 + dy * uniform_w];
        float u3 = uData[dx2 + dy2 * uniform_w];
        float u4 = uData[dx + dy2 * uniform_w];
        float r0 = (u1 * (1.0 - ratioX) * (1.0 - ratioY) +
                    u2 * ratioX * (1.0 - ratioY) +
                    u3 * ratioX * ratioY +
                    u4 * (1.0 - ratioX) * ratioY);

        int offset = uniform_w * uniform_h;
        u1 = uData[offset + dx + dy * uniform_w];
        u2 = uData[offset + dx2 + dy * uniform_w];
        u3 = uData[offset + dx2 + dy2 * uniform_w];
        u4 = uData[offset + dx + dy2 * uniform_w];
        float r1 = (u1 * (1.0 - ratioX) * (1.0 - ratioY) +
                    u2 * ratioX * (1.0 - ratioY) +
                    u3 * ratioX * ratioY +
                    u4 * (1.0 - ratioX) * ratioY);

        float diff = exp(r1-r0);
        diff = diff/(diff + 1.0f);
        float r = step(0.3, diff) * diff;
        write_imagef(outputImage, gid, (float4)(r, r, r, 1.f));
};

__kernel void CopyInput(
    __global uchar* inputArray,
    __read_only image2d_t inputImage,
    int width,
    int height
    )
{
    int x = get_global_id(0);
    int y = get_global_id(1);
    float4 pixel = read_imagef(inputImage, sampler, (int2)(x, y));
    uchar r = (uchar)(clamp(pixel.x * 255.f, 0.f, 255.f));
    uchar g = (uchar)(clamp(pixel.y * 255.f, 0.f, 255.f));
    uchar b = (uchar)(clamp(pixel.z * 255.f, 0.f, 255.f));
    uchar a = 255;
    inputArray[4 * (y * width + x)] = r;
    inputArray[4 * (y * width + x) + 1] = g;
    inputArray[4 * (y * width + x) + 2] = b;
    inputArray[4 * (y * width + x) + 3] = a;
    //inputArray[y * width + x] = (uint4)(0, 0, 0, 255);
};


__kernel void readInput(
    __global uchar* inputArray,
    __write_only image2d_t outImage,
    int width,
    int height
    )
{
    int x = get_global_id(0);
    int y = get_global_id(1);
    float r = inputArray[4 * (y * width + x)] / 255.f;
    float g = inputArray[4 * (y * width + x) + 1] / 255.f;
    float b = inputArray[4 * (y * width + x) + 2] / 255.f;
    float a = inputArray[4 * (y * width + x) + 3] / 255.f;
    write_imagef(outImage, (int2)(x, y), (float4)(r, g, b, a));
};

