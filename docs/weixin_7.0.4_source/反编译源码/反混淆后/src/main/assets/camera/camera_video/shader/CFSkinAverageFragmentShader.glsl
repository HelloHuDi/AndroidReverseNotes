precision mediump float;
varying lowp vec2 textureCoordinate;
uniform sampler2D inputImageTexture2;

uniform float diffy;
uniform float diffi;
uniform float diffq;

uniform float usery;
uniform float useri;
uniform float userq;

void main()
{
    vec4 color = texture2D(inputImageTexture2, textureCoordinate);

    float ry;
    float ri;
    float rq;
    if (color.r <= usery) {
        ry = color.r + diffy * (color.r / usery);
    } else {
        ry = color.r + diffy * ((1.0 - color.r) / (1.0 - usery));
    }
    if (color.g <= useri) {
        ri = color.g + diffi * (color.g / useri);
    } else {
        ri = color.g + diffi * ((1.0 - color.g) / (1.0 - useri));
    }
    if (color.b <= userq) {
        rq = color.b + diffq * (color.b / userq);
    } else {
        rq = color.b + diffq * ((1.0 - color.b) / (1.0 - userq));
    }
    vec3 refineRGB = vec3(ry, ri, rq);
    gl_FragColor = vec4(clamp(refineRGB, 0.0, 1.0), 1.0);
}
