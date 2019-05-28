precision highp float;
uniform vec4 currentColor;
varying lowp vec4 varyColor;
varying mat4 fragColorMatrix;

void main()
{
    gl_FragColor = currentColor;
}
