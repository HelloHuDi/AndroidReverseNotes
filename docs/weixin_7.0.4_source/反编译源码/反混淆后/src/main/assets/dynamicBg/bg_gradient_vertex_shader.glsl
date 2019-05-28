attribute vec4 position;
attribute vec4 vColor;
varying vec4 fragmentColor;

void main()
{
    gl_Position = position;
    fragmentColor = vColor;
}

