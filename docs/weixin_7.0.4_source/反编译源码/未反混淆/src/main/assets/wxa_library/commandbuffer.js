;var __getWebGLContext__;

(function(){
    var nativeBatchRender = NativeGlobal.batchRender;
    // var nativeCreateCommandBuffer = NativeGlobal.createCommandBuffer;
    var nativeRegisterAfterDoFrame= NativeGlobal.registerAfterDoFrame;
    var nativeWatcher = NativeGlobal.Watcher;
    var nativePerformanceNow = NativeGlobal.performanceNow;
    var nativeLog = NativeGlobal.log;

    var _ = (function(){
        var store = new WeakMap();
        return function (key) {
            var value = store.get(key);
            if (!value) {
                value = {
                    origin_ctx: null,
                    ctxid: 0,
                    textrueObjs: new WeakMap(),
                    programObjs: new WeakMap(),
                    webglObjs: new Map()
                };
                store.set(key, value);
            }
            return value;
        }
    })();

    var commandBufferData = {
        currentctxid: 0,
        buffer: new ArrayBuffer(),
        MAX_LEN: 512000,
        lengthPerFourBytes: 0,
        meta: new Uint32Array(2),
        float32Array: new Float32Array(),
        uint32Array: new Uint32Array(),
        offsetPerFourBytes: 0,
        //    startTime: null,
        //    endTime: null,
        //    commandCostTime: {},

        //初始化共享数据区
        init: function () {
            this.buffer = new ArrayBuffer(this.MAX_LEN);
            this.lengthPerFourBytes = this.buffer.byteLength / 4;
            this.meta = new Uint32Array(this.buffer, 0, 2);
            this.float32Array = new Float32Array(this.buffer);
            this.uint32Array = new Uint32Array(this.buffer);
            this.offsetPerFourBytes = 2;
        },
        //检查ArrayBuffer是否够用，不够就做自增长
        checkCommand: function (increasedPerFourBytes) {
            if (this.offsetPerFourBytes + increasedPerFourBytes <= this.lengthPerFourBytes) {
                return;
            }
            var newBuffer = new ArrayBuffer(this.MAX_LEN + 4 * (increasedPerFourBytes + this.lengthPerFourBytes));
            var newUint32Array = new Uint32Array(newBuffer)
            newUint32Array.set(this.uint32Array)
            this.buffer = newBuffer;
            this.lengthPerFourBytes = this.buffer.byteLength / 4;
            this.meta = new Uint32Array(this.buffer, 0, 2);
            this.uint32Array = newUint32Array;
            this.float32Array = new Float32Array(newBuffer)
        },
        pushInt32: function (val) {
            this.checkCommand(1);
            this.uint32Array[this.offsetPerFourBytes++] = val;
        },
        pushInt64: function (val) {
            this.checkCommand(2);
            var dataView = new DataView(this.buffer, this.offsetPerFourBytes * 4, 8);
            var val_hight = Math.floor(val / 4294967296);
            var val_low = val - val_hight * 4294967296;
            //字节序问题，低位放高位，高位放低位
            dataView.setUint32(0, val_low, true);
            dataView.setUint32(4, val_hight, true);
            this.offsetPerFourBytes += 2;
        },
        pushInt32Array: function (val, size) {
            this.checkCommand(size);
            this.uint32Array.set(val, this.offsetPerFourBytes);
            this.offsetPerFourBytes += size;
        },
        pushInt16Array: function (val, size) {
            // 四字节对齐
            if (size % 2 != 0) {
                size++;
            }
            this.checkCommand(size / 2);
            var int16Array = new Uint16Array(this.buffer, this.offsetPerFourBytes * 4, size);
            int16Array.set(val);
            this.offsetPerFourBytes += size / 2;
        },
        pushFloat32: function (val) {
            this.checkCommand(1);
            this.float32Array[this.offsetPerFourBytes++] = val;
        },
        pushFloat64: function (val) {
            this.checkCommand(2);
            var float64Array = new Float64Array(this.buffer, this.offsetPerFourBytes * 4, 1);
            float64Array[0] = val;
            this.offsetPerFourBytes += 2;
        },
        pushFloat32Array: function (val, size) {
            this.checkCommand(size);
            this.float32Array.set(val, this.offsetPerFourBytes);
            this.offsetPerFourBytes += size;
        },
        pushFloat64Array: function (val, size) {
            this.checkCommand(2 * size);
            var float64Array = new Float64Array(this.buffer, this.offsetPerFourBytes * 4, size);
            float64Array.set(val);
            this.offsetPerFourBytes += 2 * size;
        },
        pushArrayBuffer: function (val) {
            var byteLength = val.byteLength;
            this.pushInt32(byteLength);

            if (byteLength == 0) {
                return;
            }
            //4字节对齐
            var delta = byteLength % 4;
            var offset;
            if (delta != 0) {
                offset = (byteLength + 4 - delta) / 4;
            } else {
                offset = byteLength / 4;
            }

            this.checkCommand(offset);

            var uint8Array = new Uint8Array(this.buffer, this.offsetPerFourBytes * 4, byteLength);
            if (ArrayBuffer.isView(val)) {
                uint8Array.set(new Uint8Array(val.buffer, val.byteOffset, byteLength));
            }
            else {
                uint8Array.set(new Uint8Array(val));
            }
            this.offsetPerFourBytes += offset;
        },
        pushString: function (str) {
            var strLen = (str.length + 1);
            var len = strLen * 2;
            this.pushInt32(len);

            //4字节对齐
            var delta = len % 4;
            var offset;
            if (delta != 0) {
                offset = (len + 4 - delta) / 4;
            } else {
                offset = len / 4;
            }

            this.checkCommand(offset);
            //放入UTF16LE字符串
            var bufView = new Uint16Array(this.buffer, this.offsetPerFourBytes * 4, strLen);
            for (var i = 0; i < strLen; i++) {
                bufView[i] = str.charCodeAt(i);
            }

            this.offsetPerFourBytes += offset;
        },

        //通知客户端处理buffer
        batchRender: function () {
            this.meta[0] = this.offsetPerFourBytes;
            this.offsetPerFourBytes = 2;
            this.currentctxid = 0;
            return nativeBatchRender(this.buffer);
        },
    };

    var watcherData = {
        handler: {},
        toDeleteList: []
    };

    function onBatchRender () {
        for (var i = 0; i < watcherData.toDeleteList.length; i++) {
            var id = watcherData.toDeleteList[i];
            if (watcherData.handler[id]) {
                watcherData.handler[id]();
                delete watcherData.handler[id];
            }
        }
        watcherData.toDeleteList = [];
        if (commandBufferData.offsetPerFourBytes > 2) {
            commandBufferData.batchRender();
        }
    }

    commandBufferData.init();

    NativeGlobal.EventHandler.addEventListener('watcherdestruct', function (id) {
        if (watcherData.handler[id]) {
            watcherData.toDeleteList.push(id);
        }
    });
    nativeRegisterAfterDoFrame(onBatchRender);

    function checkContextChange(ctxid) {
        if (commandBufferData.currentctxid != ctxid) {
            commandBufferData.pushInt32(999);
            commandBufferData.pushInt64(ctxid);
            commandBufferData.currentctxid = ctxid;
            //commandBufferData.meta[1] ^= 0x1;
        }
    }

    __getWebGLContext__ = function (origin_ctx) {
        var __WebGLRenderingContextProto__ = {
            // DEMO
            vertexAttribPointer: function (a, b, c, d, e, f) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([1, a, b, c, (d ? 1 : 0), e, f], 7);
            },
            // DEMO
            activeTexture: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([2, a], 2);
            },
            uniform1i: function (a, b) {
                checkContextChange(_(this).ctxid);
                if (typeof b === 'boolean') b = b ? 1 : 0;
                commandBufferData.pushInt32Array([3, a.id, b], 3);
            },
            // DEMO
            drawElements: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([4, a, b, c, d], 5);
            },
            // DEMO
            bindBuffer: function (target, buffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([5, target, (buffer ? buffer.id : 0)], 3);
            },
            // DEMO
            bindTexture: function (target, texture) {
                var data = _(this);
                checkContextChange(data.ctxid);
                var textureId = data.textrueObjs.get(texture) || 0;
                commandBufferData.pushInt32Array([6, target, textureId], 3);
            },
            // DEMO
            uniformMatrix4fv: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([7, a.id, (b ? 1 : 0), c.length], 4);
                commandBufferData.pushFloat32Array(c, c.length);
            },
            // DEMO
            viewport: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([8, a, b, c, d], 5);
            },
            // DEMO
            clear: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([9, param], 2);
            },
            // DEMO
            createProgram: function () {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32(10);
                var program = {};
                var programId = commandBufferData.batchRender();
                data.programObjs.set(program, programId);
                data.webglObjs.set('Program-' + programId, program);
                return program;
            },
            // DEMO
            createShader: function (shaderType) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([11, shaderType], 2);
                var shader = {};
                shader.id = commandBufferData.batchRender();
                data.webglObjs.set('Shader-' + shader.id, shader);
                return shader;
            },
            // DEMO
            shaderSource: function (shader, source) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([12, shader.id], 2);
                commandBufferData.pushString(source);
            },
            // DEMO
            getShaderInfoLog: function (shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([13, shader.id], 2);
                return commandBufferData.batchRender();
            },
            // DEMO
            getShaderParameter: function (shader, pname) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([14, shader.id, pname], 3);
                return commandBufferData.batchRender();
            },
            // DEMO
            compileShader: function (shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([15, shader.id], 2);
            },
            // DEMO
            attachShader: function (program, shader) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([16, data.programObjs.get(program), shader.id], 3);
            },
            // DEMO
            linkProgram: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([17, data.programObjs.get(program)], 2);
            },
            // DEMO
            getProgramParameter: function (program, pname) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([18, data.programObjs.get(program), pname], 3);
                return commandBufferData.batchRender();
            },
            // DEMO
            useProgram: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([19, data.programObjs.get(program)], 2);
            },
            // DEMO
            getAttribLocation: function (program, name) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([20, data.programObjs.get(program)], 2);
                commandBufferData.pushString(name);
                return commandBufferData.batchRender();
            },
            // DEMO
            enableVertexAttribArray: function (index) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([21, index], 2);
            },
            // DEMO
            getUniformLocation: function (program, name) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([22, data.programObjs.get(program)], 2);
                commandBufferData.pushString(name);
                var location = {};
                location.id = commandBufferData.batchRender();
                return location;
            },
            // DEMO
            createBuffer: function () {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32(23);
                var buffer = {};
                buffer.id = commandBufferData.batchRender();
                data.webglObjs.set('Buffer-' + buffer.id, buffer);
                return buffer;
            },
            // DEMO
            bufferData: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                var v;
                if (typeof b === 'number' && !isNaN(b)) {
                    commandBufferData.pushInt32Array([24, a, c], 3);
                    commandBufferData.pushInt64(b);
                }
                else {
                    commandBufferData.pushInt32Array([25, a, c], 3);//注意参数顺序
                    commandBufferData.pushArrayBuffer(b);
                }
            },
            // DEMO
            createTexture: function () {
                var data = _(this);
                var ctxid = data.ctxid;
                checkContextChange(ctxid)
                commandBufferData.pushInt32(26);
                var textureId = commandBufferData.batchRender();
                var texture = new nativeWatcher();
                texture.setExtra = undefined;
                texture.getExtra = undefined;
                watcherData.handler[texture.__id] = function () {
                    // nativeLog("cr: texture auto delete id:" + textureId)
                    checkContextChange(ctxid)
                    commandBufferData.pushInt32Array([78, textureId], 2);
                }
                data.textrueObjs.set(texture, textureId);
                return texture;
            },
            // DEMO
            pixelStorei: function (a, b) {
                checkContextChange(_(this).ctxid);
                if (typeof b === 'boolean') b = b ? 1 : 0;
                commandBufferData.pushInt32Array([27, a, b], 3);
            },
            // DEMO

            texImage2D: function (a, b, c, d, e, f, g, h, i) {
                checkContextChange(_(this).ctxid);
                var argc = arguments.length;
                if (argc == 6) {
                    commandBufferData.pushInt32Array([28, a, b, c, d, e], 6);
                    commandBufferData.pushInt64(f.__uid());
                }
                else if (argc == 9) {
                    if (i == null) {
                        commandBufferData.pushInt32Array([29, a, b, c, d, e, f, g, h], 9);
                    }
                    else {
                        commandBufferData.pushInt32Array([30, a, b, c, d, e, f, g, h], 9);
                        /*
                        this.note = type == h
                        A Uint8Array must be used if type is gl.UNSIGNED_BYTE.
                        A Uint16Array must be used if type is either gl.UNSIGNED_SHORT_5_6_5, gl.UNSIGNED_SHORT_4_4_4_4, gl.UNSIGNED_SHORT_5_5_5_1, gl.UNSIGNED_SHORT or ext.HALF_FLOAT_OES.
                        A Uint32Array must be used if type is gl.UNSIGNED_INT or ext.UNSIGNED_INT_24_8_WEBGL.
                        A Float32Array must be used if type is gl.FLOAT.
                        */
                        if (h == this.UNSIGNED_BYTE) {
                            commandBufferData.pushArrayBuffer(i);
                        }
                        else if (h == this.UNSIGNED_SHORT_5_6_5 || h == this.UNSIGNED_SHORT_4_4_4_4 || h == this.UNSIGNED_SHORT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushInt16Array(i, length);
                        }
                        else if (h == this.UNSIGNED_INT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushInt32Array(i, length);
                        }
                        else if (h == this.FLOAT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushFloat32Array(i, length);
                        }
                    }


                }
                commandBufferData.batchRender();
            },
            // DEMO
            texParameteri: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([31, a, b, c], 4);
            },
            // DEMO
            enable: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([32, param], 2);
            },
            // DEMO
            clearColor: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(33);
                commandBufferData.pushFloat32Array([a, b, c, d], 4);
            },
            disable: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([34, param], 2);
            },
            getExtension: function (name) {
                var ctxid = _(this).ctxid;
                checkContextChange(ctxid);
                commandBufferData.pushInt32(35);
                commandBufferData.pushString(name);
                var ext = commandBufferData.batchRender();
                if (!ext) {
                    return ext;
                }
                if (name == "ANGLE_instanced_arrays") {
                    var extension = {
                        drawArraysInstancedANGLE: function (mode, first, count, instanceCount) {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32Array([143, mode, first, count, instanceCount], 5);
                        },
                        drawElementsInstancedANGLE: function (mode, first, type, indice, instanceCount) {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32Array([144, mode, first, type, indice, instanceCount], 6);
                        },
                        vertexAttribDivisorANGLE: function (index, divisor) {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32Array([145, index, divisor], 3);
                        }
                    };
                    extension.VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE = ext.VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE;
                    return extension;
                }
                else if (name == "OES_vertex_array_object") {
                    var extension = {
                        createVertexArrayOES: function () {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32(148);
                            var ret = commandBufferData.batchRender();
                            ret.id = ret.__index();
                            return ret;
                        },
                        deleteVertexArrayOES: function (obj) {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32Array([149, obj.id], 2);
                        },
                        isVertexArrayOES: function (obj) {
                            checkContextChange(ctxid);
                            commandBufferData.pushInt32Array([150, obj.id], 2);
                            return commandBufferData.batchRender();
                        },
                        bindVertexArrayOES: function (obj) {
                            checkContextChange(ctxid);
                            var id = obj == null ? 0 : obj.id;
                            commandBufferData.pushInt32Array([151, id], 2);
                        }
                    };
                    extension.VERTEX_ARRAY_BINDING_OES = ext.VERTEX_ARRAY_BINDING_OES;
                    return extension;
                }
                return ext;
            },
            getParameter: function (pname) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([36, pname], 2);
                const ret = commandBufferData.batchRender();
                switch (pname) {
                    case this.ARRAY_BUFFER_BINDING: // buffer
                    case this.ELEMENT_ARRAY_BUFFER_BINDING:  // buffer
                        return data.webglObjs.get('Buffer-' + ret) || null;
                    case this.CURRENT_PROGRAM: // program
                        return data.webglObjs.get('Program-' + ret) || null;
                    case this.FRAMEBUFFER_BINDING: // framebuffer
                        return data.webglObjs.get('Framebuffer-' + ret) || null;
                    case this.RENDERBUFFER_BINDING: // renderbuffer
                        return data.webglObjs.get('Renderbuffer-' + ret) || null;
                    default:
                        return ret;
                }
            },
            getSupportedExtensions: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(37);
                return commandBufferData.batchRender();
            },
            blendFunc: function (s, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([38, s, d], 3);
            },
            getShaderPrecisionFormat: function (s, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([39, s, d], 3);
                const resultString = commandBufferData.batchRender();
                const arr = resultString.split(',');
                var shaderPrecisionFormat = {};
                shaderPrecisionFormat.rangeMin = arr[0];;
                shaderPrecisionFormat.rangeMax = arr[1];
                shaderPrecisionFormat.precision = arr[2];
                return shaderPrecisionFormat;
            },
            bindAttribLocation: function (program, index, name) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([40, data.programObjs.get(program), index], 3);
                commandBufferData.pushString(name);
            },
            deleteShader: function (shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([41, shader ? shader.id : 0], 2);
            },
            drawArrays: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([42, a, b, c], 4);
            },
            isEnabled: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([43, param], 2);
                return commandBufferData.batchRender();
            },
            depthMask: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([44, (param ? 1 : 0)], 2);
            },
            stencilFunc: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([45, a, b, c], 4);
            },
            stencilOp: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([46, a, b, c], 4);
            },
            stencilMask: function (param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([47, param], 2);
            },
            scissor: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([48, a, b, c, d], 5);
            },
            bufferSubData: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([49, a, b], 3);
                commandBufferData.pushArrayBuffer(c);
            },
            blendFuncSeparate: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([50, a, b, c, d], 5);
            },
            uniform1f: function (a, b) {
                checkContextChange(_(this).ctxid);
                commandBufferData.checkCommand(3);
                commandBufferData.uint32Array.set([51, a.id], commandBufferData.offsetPerFourBytes);
                commandBufferData.float32Array[commandBufferData.offsetPerFourBytes+2] = b;
                commandBufferData.offsetPerFourBytes += 3;
            },
            clearDepth: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(52);
                commandBufferData.pushFloat32(a);
            },
            clearStencil: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([53, a], 2);
            },
            depthFunc: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([54, a], 2);
            },
            frontFace: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([55, a], 2);
            },
            cullFace: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([56, a], 2);
            },
            blendEquationSeparate: function (a, b) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([57, a, b], 3);
            },
            createFramebuffer: function () {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32(58);
                var framebuffer = {};
                framebuffer.id = commandBufferData.batchRender();
                data.webglObjs.set('Framebuffer-' + framebuffer.id, framebuffer);
                return framebuffer;
            },
            // DEMO
            bindFramebuffer: function (target, framebuffer) {
                checkContextChange(_(this).ctxid);
                //framebuffer为null时，返回-1，EJecta对-1特殊处理
                commandBufferData.pushInt32Array([59, target, (framebuffer ? framebuffer.id : -1)], 3);
            },
            framebufferTexture2D: function (target, attachment, textarget, texture, level) {
                var data = _(this);
                checkContextChange(data.ctxid);
                var textureId = data.textrueObjs.get(texture) || 0;
                commandBufferData.pushInt32Array([60, target, attachment, textarget, level, textureId], 6);
            },
            createRenderbuffer: function () {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32(61);
                var renderBuffer = {};
                renderBuffer.id = commandBufferData.batchRender();
                data.webglObjs.set('Renderbuffer-' + renderBuffer.id, renderBuffer);
                return renderBuffer;
            },
            bindRenderbuffer: function (target, renderbuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([62, target, (renderbuffer ? renderbuffer.id : 0)], 3);
            },
            renderbufferStorage: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([63, a, b, c, d], 5);
            },
            framebufferRenderbuffer: function (target, attachment, renderbuffertarget, renderbuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([64, target, attachment, renderbuffertarget, (renderbuffer ? renderbuffer.id : 0)], 5);
            },
            colorMask: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([65, (a ? 1 : 0), (b ? 1 : 0), (c ? 1 : 0), (d ? 1 : 0)], 5);
            },
            getProgramInfoLog: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([66, data.programObjs.get(program)], 2);
                return commandBufferData.batchRender();
            },
            getActiveAttrib: function (program, index) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([67, data.programObjs.get(program), index], 3);
                const resultString = commandBufferData.batchRender();
                const arr = resultString.split(',');
                var activeInfo = {};
                activeInfo.type = Number(arr[0]);
                activeInfo.size = Number(arr[1]);
                activeInfo.name = arr[2];
                return activeInfo;
            },
            getActiveUniform: function (program, index) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([68, data.programObjs.get(program), index], 3);
                const resultString = commandBufferData.batchRender();
                if (resultString) {
                    const arr = resultString.split(',');
                    var activeInfo = {};
                    activeInfo.type = Number(arr[0]);
                    activeInfo.size = Number(arr[1]);
                    activeInfo.name = arr[2];
                    return activeInfo;
                }
                return null;
            },
            uniform3f: function (a, b, c, d) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([69, a.id], 2);
                commandBufferData.pushFloat32Array([b, c, d], 3);
            },
            uniform1iv: function (a, b) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([70, a.id, b.length], 3);
                commandBufferData.pushInt32Array(b, b.length);
            },
            uniform3fv: function (a, b) {
                checkContextChange(_(this).ctxid);
                commandBufferData.checkCommand(3 + b.length);
                commandBufferData.uint32Array.set([71, a.id, b.length], commandBufferData.offsetPerFourBytes);
                commandBufferData.offsetPerFourBytes += 3;
                commandBufferData.float32Array.set(b, commandBufferData.offsetPerFourBytes);
                commandBufferData.offsetPerFourBytes += b.length;
            },
            uniform2f: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([72, a.id], 2);
                commandBufferData.pushFloat32Array([b, c], 2);
            },
            uniformMatrix3fv: function (a, b, c) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([73, a.id, (b ? 1 : 0), c.length], 4);
                commandBufferData.pushFloat32Array(c, c.length);
            },
            disableVertexAttribArray: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([74, a], 2);
            },
            generateMipmap: function (a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([75, a], 2);
            },
            uniform4fv: function (a, b) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([76, a.id, b.length], 3);
                commandBufferData.pushFloat32Array(b, b.length);
            },
            getError: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(77);
                return commandBufferData.batchRender();
            },
            deleteTexture: function (texture) {
                var data = _(this);
                checkContextChange(data.ctxid);
                var textureId = data.textrueObjs.get(texture) || 0;
                commandBufferData.pushInt32Array([78, textureId], 2);
                delete watcherData.handler[texture.__id];
            },
            deleteBuffer: function (buffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([79, (buffer ? buffer.id : 0)], 2);
            },
            getShaderSource: function (shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([80, shader.id], 2);
                return commandBufferData.batchRender();
            },
            deleteProgram: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([81, data.programObjs.get(program)], 2);
            },
            deleteFramebuffer: function (framebuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([82, framebuffer ? framebuffer.id : 0], 2);
            },
            deleteRenderbuffer: function (renderbuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([83, renderbuffer ? renderbuffer.id : 0], 2);
            },
            texSubImage2D: function (a, b, c, d, e, f, g, h, i) {
                checkContextChange(_(this).ctxid);
                var argc = arguments.length;
                if (argc == 7) {
                    commandBufferData.pushInt32Array([84, a, b, c, d, e, f], 7);
                    commandBufferData.pushInt64(g.__uid());
                }
                else if (argc == 9) {
                    if (i == null) {
                        commandBufferData.pushInt32Array([85, a, b, c, d, e, f, g, h], 9);
                    }
                    else {
                        commandBufferData.pushInt32Array([86, a, b, c, d, e, f, g, h], 9);

                        /*
                        this.note = type == h
                        A Uint8Array must be used if type is gl.UNSIGNED_BYTE.
                        A Uint16Array must be used if type is either gl.UNSIGNED_SHORT_5_6_5, gl.UNSIGNED_SHORT_4_4_4_4, gl.UNSIGNED_SHORT_5_5_5_1, gl.UNSIGNED_SHORT or ext.HALF_FLOAT_OES.
                        A Uint32Array must be used if type is gl.UNSIGNED_INT or ext.UNSIGNED_INT_24_8_WEBGL.
                        A Float32Array must be used if type is gl.FLOAT.
                        */
                        if (h == this.UNSIGNED_BYTE) {
                            commandBufferData.pushArrayBuffer(i);
                        }
                        else if (h == this.UNSIGNED_SHORT_5_6_5 || h == this.UNSIGNED_SHORT_4_4_4_4 || h == this.UNSIGNED_SHORT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushInt16Array(i, length);
                        }
                        else if (h == this.UNSIGNED_INT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushInt32Array(i, length);
                        }
                        else if (h == this.FLOAT) {
                            var length = i.length;
                            commandBufferData.pushInt32(length);
                            commandBufferData.pushFloat32Array(i, length);
                        }
                    }
                }
                commandBufferData.batchRender();
            },
            uniform4f: function (a, b, c, d, e) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([87, a.id], 2);
                commandBufferData.pushFloat32Array([b, c, d, e], 4);
            },
            isBuffer: function (buffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([88, buffer.id], 2);
                return commandBufferData.batchRender();
            },
            isContextLost: function () {
                // 89
                return false;
            },
            isFramebuffer: function (framebuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([90, framebuffer.id], 2);
                return commandBufferData.batchRender();
            },
            isProgram: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([91, data.programObjs.get(program)], 2);
                return commandBufferData.batchRender();
            },
            isRenderbuffer: function (renderBuffer) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([92, renderBuffer.id], 2);
                return commandBufferData.batchRender();
            },
            isShader: function (shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([93, shader.id], 2);
                return commandBufferData.batchRender();
            },
            isTexture: function (texture) {
                var data = _(this);
                checkContextChange(data.ctxid);
                var textureId = data.textrueObjs.get(texture) || 0;
                commandBufferData.pushInt32Array([94, textureId], 2);
                return commandBufferData.batchRender();
            },
            uniform2i: function (location, v0, v1) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([95, location.id, v0, v1], 4);
            },
            uniform3i: function (location, v0, v1, v2) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([96, location.id, v0, v1, v2], 5);
            },
            uniform4i: function (location, v0, v1, v2, v3) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([97, location.id, v0, v1, v2, v3], 6);
            },
            uniform1fv: function (location, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([98, location.id, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            uniform2fv: function (location, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([99, location.id, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            uniform2iv: function (location, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([100, location.id, value.length], 3);
                commandBufferData.pushInt32Array(value, value.length);
            },
            uniform3iv: function (location, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([101, location.id, value.length], 3);
                commandBufferData.pushInt32Array(value, value.length);
            },
            uniform4iv: function (location, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([102, location.id, value.length], 3);
                commandBufferData.pushInt32Array(value, value.length);
            },
            uniformMatrix2fv: function (location, transpose, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([103, location.id, (transpose ? 1 : 0), value.length], 4);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            vertexAttrib1f: function (index, v0) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([104, index], 2);
                commandBufferData.pushFloat32(v0);
            },
            vertexAttrib2f: function (index, v0, v1) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([105, index], 2);
                commandBufferData.pushFloat32Array([v0, v1], 2);
            },
            vertexAttrib3f: function (index, v0, v1, v2) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([106, index], 2);
                commandBufferData.pushFloat32Array([v0, v1, v2], 3);
            },
            vertexAttrib4f: function (index, v0, v1, v2, v3) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([107, index], 2);
                commandBufferData.pushFloat32Array([v0, v1, v2, v3], 4);
            },
            vertexAttrib1fv: function (index, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([108, index, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            vertexAttrib2fv: function (index, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([109, index, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            vertexAttrib3fv: function (index, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([110, index, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            vertexAttrib4fv: function (index, value) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([111, index, value.length], 3);
                commandBufferData.pushFloat32Array(value, value.length);
            },
            blendColor: function (r, g, b, a) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(112);
                commandBufferData.pushFloat32Array([r, g, b, a], 4);
            },
            checkFramebufferStatus: function (target) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([113, target], 2);
                return commandBufferData.batchRender();
            },
            compressedTexImage2D: function (target, level, internalformat, width, height, border, pixels) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([114, target, level, internalformat, width, height, border], 7);
                commandBufferData.pushArrayBuffer(pixels);
            },
            compressedTexSubImage2D: function (target, level, xoffset, yoffset, width, height, format, pixels) {
                /*
                checkContextChange(_(this).ctxid);
                commandBufferData.batchRender();
                origin_ctx.compressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, pixels);
                */
            },
            copyTexImage2D: function (target, level, internalformat, x, y, width, height, border) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([116, target, level, internalformat, x, y, width, height, border], 9);
            },
            copyTexSubImage2D: function (target, level, xoffset, yoffset, x, y, width, height) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([117, target, level, xoffset, yoffset, x, y, width, height], 9);
            },
            depthRange: function (zNear, zFar) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(118);
                commandBufferData.pushFloat32Array([zNear, zFar], 2);
            },
            detachShader: function (program, shader) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([119, data.programObjs.get(program), shader.id], 3);
            },
            flush: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(120);
                commandBufferData.batchRender();
            },
            finish: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(121);
                commandBufferData.batchRender();
            },
            hint: function (target, mode) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([122, target, mode], 3);
            },
            lineWidth: function (width) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(123);
                commandBufferData.pushFloat32(width);
            },
            polygonOffset: function (factor, units) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(124);
                commandBufferData.pushFloat32Array([factor, units], 2);
            },
            sampleCoverage: function (value, invert) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(125);
                commandBufferData.pushFloat32(value);
                commandBufferData.pushInt32((invert ? 1 : 0));
            },
            stencilFuncSeparate: function (face, func, ref, mask) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([126, face, func, ref, mask], 5);
            },
            stencilMaskSeparate: function (face, mask) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([127, face, mask], 3);
            },
            stencilOpSeparate: function (face, fail, zfail, zpass) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([128, face, fail, zfail, zpass], 5);
            },
            texParameterf: function (target, pname, param) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([129, target, pname], 3);
                commandBufferData.pushFloat32(param);
            },
            validateProgram: function (program) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([130, data.programObjs.get(program)], 2);
            },

            getBufferParameter: function (target, pname) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([131, target, pname], 3);
                return commandBufferData.batchRender();
            },
            getRenderbufferParameter: function (target, pname) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([132, target, pname], 3);
                return commandBufferData.batchRender();
            },
            getTexParameter: function (target, pname) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([133, target, pname], 3);
                return commandBufferData.batchRender();
            },
            getVertexAttribOffset: function (index, pname) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([134, index, pname], 3);
                return commandBufferData.batchRender();
            },
            wxSetContextAttributes: function (dic) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([135, dic.antialias, dic.antialiasSamples], 3);
            },
            //        this.wxBindCanvasTexture = function (target, canvas) {
            //            checkContextChange(_(this).ctxid);
            //            commandBufferData.pushInt32Array([136, target], 2);
            //            commandBufferData.pushInt64(canvas.__id);
            //        }
            getContextAttributes: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(137);
                return commandBufferData.batchRender();
            },
            readPixels: function (x, y, width, height, format, type, pixels) {
                var data = _(this);
                checkContextChange(data.ctxid);
                //138
                commandBufferData.batchRender();
                return data.origin_ctx.readPixels(x, y, width, height, format, type, pixels);
            },
            getAttachedShaders: function (progarm) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([139, data.programObjs.get(program)], 2);
                const resultString = commandBufferData.batchRender();
                var arr = resultString.split(',');
                for (i = 0, len = arr.length; i < len; i++) {
                    arr[i] = data.webglObjs.get('Shader-' + arr[i]);
                }
                return arr;
            },
            getFramebufferAttachmentParameter: function (target, attachment, pname) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([140, target, attachment, pname], 4);
                const result = commandBufferData.batchRender();
                switch (pname) {
                    case this.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME:
                        return data.webglObjs.get('Renderbuffer-' + result) || null;
                    default:
                        return result;
                }
            },
            getVertexAttrib: function (index, pname) {
                var data = _(this);
                checkContextChange(data.ctxid);
                commandBufferData.pushInt32Array([141, index, pname], 3);
                const result = commandBufferData.batchRender();
                switch (pname) {
                    case this.VERTEX_ATTRIB_ARRAY_BUFFER_BINDING:
                        return data.webglObjs.get('Buffer-' + result) || null;
                    default:
                        return result;
                }
            },
            blendEquation: function (mode) {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32Array([142, mode], 2);
            },

            submit: function () {
                return commandBufferData.batchRender();
            },

            // ClearBufferMask
            DEPTH_BUFFER_BIT: origin_ctx.DEPTH_BUFFER_BIT,
            STENCIL_BUFFER_BIT: origin_ctx.STENCIL_BUFFER_BIT,
            COLOR_BUFFER_BIT: origin_ctx.COLOR_BUFFER_BIT,

            // Boolean
            FALSE: origin_ctx.FALSE,
            TRUE: origin_ctx.TRUE,

            // BeginMode
            POINTS: origin_ctx.POINTS,
            LINES: origin_ctx.LINES,
            LINE_LOOP: origin_ctx.LINE_LOOP,
            LINE_STRIP: origin_ctx.LINE_STRIP,
            TRIANGLES: 4,
            TRIANGLE_STRIP: origin_ctx.TRIANGLE_STRIP,
            TRIANGLE_FAN: origin_ctx.TRIANGLE_FAN,

            // BlendingFactorDest
            ZERO: origin_ctx.ZERO,
            ONE: origin_ctx.ONE,
            SRC_COLOR: origin_ctx.SRC_COLOR,
            ONE_MINUS_SRC_COLOR: origin_ctx.ONE_MINUS_SRC_COLOR,
            SRC_ALPHA: origin_ctx.SRC_ALPHA,
            ONE_MINUS_SRC_ALPHA: origin_ctx.ONE_MINUS_SRC_ALPHA,
            DST_ALPHA: origin_ctx.DST_ALPHA,
            ONE_MINUS_DST_ALPHA: origin_ctx.ONE_MINUS_DST_ALPHA,

            // BlendingFactorSrc
            // GL_ZERO
            // GL_ONE
            DST_COLOR: origin_ctx.DST_COLOR,
            ONE_MINUS_DST_COLOR: origin_ctx.ONE_MINUS_DST_COLOR,
            SRC_ALPHA_SATURATE: origin_ctx.SRC_ALPHA_SATURATE,
            // GL_SRC_ALPHA

            // GL_ONE_MINUS_SRC_ALPHA
            // GL_DST_ALPHA
            // GL_ONE_MINUS_DST_ALPHA

            // BlendEquationSeparate
            FUNC_ADD: origin_ctx.FUNC_ADD,
            BLEND_EQUATION: origin_ctx.BLEND_EQUATION,
            BLEND_EQUATION_RGB: origin_ctx.BLEND_EQUATION_RGB,
            BLEND_EQUATION_ALPHA: origin_ctx.BLEND_EQUATION_ALPHA,

            // BlendSubtract
            FUNC_SUBTRACT: origin_ctx.FUNC_SUBTRACT,
            FUNC_REVERSE_SUBTRACT: origin_ctx.FUNC_REVERSE_SUBTRACT,

            // Separate Blend Functions
            BLEND_DST_RGB: origin_ctx.BLEND_DST_RGB,
            BLEND_SRC_RGB: origin_ctx.BLEND_SRC_RGB,
            BLEND_DST_ALPHA: origin_ctx.BLEND_DST_ALPHA,
            BLEND_SRC_ALPHA: origin_ctx.BLEND_SRC_ALPHA,
            CONSTANT_COLOR: origin_ctx.CONSTANT_COLOR,
            ONE_MINUS_CONSTANT_COLOR: origin_ctx.ONE_MINUS_CONSTANT_COLOR,
            CONSTANT_ALPHA: origin_ctx.CONSTANT_ALPHA,
            ONE_MINUS_CONSTANT_ALPHA: origin_ctx.ONE_MINUS_CONSTANT_ALPHA,
            BLEND_COLOR: origin_ctx.BLEND_COLOR,

            // Buffer Objects
            ARRAY_BUFFER: 34962,
            ELEMENT_ARRAY_BUFFER: 34963,
            ARRAY_BUFFER_BINDING: origin_ctx.ARRAY_BUFFER_BINDING,
            ELEMENT_ARRAY_BUFFER_BINDING: origin_ctx.ELEMENT_ARRAY_BUFFER_BINDING,

            STREAM_DRAW: origin_ctx.STREAM_DRAW,
            STATIC_DRAW: origin_ctx.STATIC_DRAW,
            DYNAMIC_DRAW: origin_ctx.DYNAMIC_DRAW,

            BUFFER_SIZE: origin_ctx.BUFFER_SIZE,
            BUFFER_USAGE: origin_ctx.BUFFER_USAGE,

            CURRENT_VERTEX_ATTRIB: origin_ctx.CURRENT_VERTEX_ATTRIB,

            // CullFaceMode
            FRONT: origin_ctx.FRONT,
            BACK: origin_ctx.BACK,
            FRONT_AND_BACK: origin_ctx.FRONT_AND_BACK,

            // EnableCap
            TEXTURE_2D: 3553,
            CULL_FACE: origin_ctx.CULL_FACE,
            BLEND: origin_ctx.BLEND,
            DITHER: origin_ctx.DITHER,
            STENCIL_TEST: origin_ctx.STENCIL_TEST,
            DEPTH_TEST: origin_ctx.DEPTH_TEST,
            SCISSOR_TEST: origin_ctx.SCISSOR_TEST,
            POLYGON_OFFSET_FILL: origin_ctx.POLYGON_OFFSET_FILL,
            SAMPLE_ALPHA_TO_COVERAGE: origin_ctx.SAMPLE_ALPHA_TO_COVERAGE,
            SAMPLE_COVERAGE: origin_ctx.SAMPLE_COVERAGE,

            // ErrorCode
            NO_ERROR: origin_ctx.NO_ERROR,
            INVALID_ENUM: origin_ctx.INVALID_ENUM,
            INVALID_VALUE: origin_ctx.INVALID_VALUE,
            INVALID_OPERATION: origin_ctx.INVALID_OPERATION,
            OUT_OF_MEMORY: origin_ctx.OUT_OF_MEMORY,

            // FrontFaceDirection
            CW: origin_ctx.CW,
            CCW: origin_ctx.CCW,

            // GetPName
            LINE_WIDTH: origin_ctx.LINE_WIDTH,
            ALIASED_POINT_SIZE_RANGE: origin_ctx.ALIASED_POINT_SIZE_RANGE,
            ALIASED_LINE_WIDTH_RANGE: origin_ctx.ALIASED_LINE_WIDTH_RANGE,
            CULL_FACE_MODE: origin_ctx.CULL_FACE_MODE,
            FRONT_FACE: origin_ctx.FRONT_FACE,
            DEPTH_RANGE: origin_ctx.DEPTH_RANGE,
            DEPTH_WRITEMASK: origin_ctx.DEPTH_WRITEMASK,
            DEPTH_CLEAR_VALUE: origin_ctx.DEPTH_CLEAR_VALUE,
            DEPTH_FUNC: origin_ctx.DEPTH_FUNC,
            STENCIL_CLEAR_VALUE: origin_ctx.STENCIL_CLEAR_VALUE,
            STENCIL_FUNC: origin_ctx.STENCIL_FUNC,
            STENCIL_FAIL: origin_ctx.STENCIL_FAIL,
            STENCIL_PASS_DEPTH_FAIL: origin_ctx.STENCIL_PASS_DEPTH_FAIL,
            STENCIL_PASS_DEPTH_PASS: origin_ctx.STENCIL_PASS_DEPTH_PASS,
            STENCIL_REF: origin_ctx.STENCIL_REF,
            STENCIL_VALUE_MASK: origin_ctx.STENCIL_VALUE_MASK,
            STENCIL_WRITEMASK: origin_ctx.STENCIL_WRITEMASK,
            STENCIL_BACK_FUNC: origin_ctx.STENCIL_BACK_FUNC,
            STENCIL_BACK_FAIL: origin_ctx.STENCIL_BACK_FAIL,
            STENCIL_BACK_PASS_DEPTH_FAIL: origin_ctx.STENCIL_BACK_PASS_DEPTH_FAIL,
            STENCIL_BACK_PASS_DEPTH_PASS: origin_ctx.STENCIL_BACK_PASS_DEPTH_PASS,
            STENCIL_BACK_REF: origin_ctx.STENCIL_BACK_REF,
            STENCIL_BACK_VALUE_MASK: origin_ctx.STENCIL_BACK_VALUE_MASK,
            STENCIL_BACK_WRITEMASK: origin_ctx.STENCIL_BACK_WRITEMASK,
            VIEWPORT: origin_ctx.VIEWPORT,
            SCISSOR_BOX: origin_ctx.SCISSOR_BOX,
            // GL_SCISSOR_TEST
            COLOR_CLEAR_VALUE: origin_ctx.COLOR_CLEAR_VALUE,
            COLOR_WRITEMASK: origin_ctx.COLOR_WRITEMASK,
            UNPACK_ALIGNMENT: origin_ctx.UNPACK_ALIGNMENT,
            PACK_ALIGNMENT: origin_ctx.PACK_ALIGNMENT,
            MAX_TEXTURE_SIZE: origin_ctx.MAX_TEXTURE_SIZE,
            MAX_VIEWPORT_DIMS: origin_ctx.MAX_VIEWPORT_DIMS,
            SUBPIXEL_BITS: origin_ctx.SUBPIXEL_BITS,
            RED_BITS: origin_ctx.RED_BITS,
            GREEN_BITS: origin_ctx.GREEN_BITS,
            BLUE_BITS: origin_ctx.BLUE_BITS,
            ALPHA_BITS: origin_ctx.ALPHA_BITS,
            DEPTH_BITS: origin_ctx.DEPTH_BITS,
            STENCIL_BITS: origin_ctx.STENCIL_BITS,
            POLYGON_OFFSET_UNITS: origin_ctx.POLYGON_OFFSET_UNITS,
            // GL_POLYGON_OFFSET_FILL
            POLYGON_OFFSET_FACTOR: origin_ctx.POLYGON_OFFSET_FACTOR,
            TEXTURE_BINDING_2D: origin_ctx.TEXTURE_BINDING_2D,
            SAMPLE_BUFFERS: origin_ctx.SAMPLE_BUFFERS,
            SAMPLES: origin_ctx.SAMPLES,
            SAMPLE_COVERAGE_VALUE: origin_ctx.SAMPLE_COVERAGE_VALUE,
            SAMPLE_COVERAGE_INVERT: origin_ctx.SAMPLE_COVERAGE_INVERT,

            // GetTextureParameter
            // GL_TEXTURE_MAG_FILTER
            // GL_TEXTURE_MIN_FILTER
            // GL_TEXTURE_WRAP_S
            // GL_TEXTURE_WRAP_T

            NUM_COMPRESSED_TEXTURE_FORMATS: origin_ctx.NUM_COMPRESSED_TEXTURE_FORMATS,
            COMPRESSED_TEXTURE_FORMATS: origin_ctx.COMPRESSED_TEXTURE_FORMATS,

            // HintMode
            DONT_CARE: origin_ctx.DONT_CARE,
            FASTEST: origin_ctx.FASTEST,
            NICEST: origin_ctx.NICEST,

            // HintTarget
            GENERATE_MIPMAP_HINT: origin_ctx.GENERATE_MIPMAP_HINT,

            // DataType
            BYTE: origin_ctx.BYTE,
            UNSIGNED_BYTE: origin_ctx.UNSIGNED_BYTE,
            SHORT: origin_ctx.SHORT,
            UNSIGNED_SHORT: 5123,
            INT: origin_ctx.INT,
            UNSIGNED_INT: origin_ctx.UNSIGNED_INT,
            FLOAT: 5126,
            FIXED: origin_ctx.FIXED,

            // PixelFormat
            DEPTH_COMPONENT: origin_ctx.DEPTH_COMPONENT,
            ALPHA: origin_ctx.ALPHA,
            RGB: origin_ctx.RGB,
            RGBA: origin_ctx.RGBA,
            LUMINANCE: origin_ctx.LUMINANCE,
            LUMINANCE_ALPHA: origin_ctx.LUMINANCE_ALPHA,

            // PixelType
            // GL_UNSIGNED_BYTE
            UNSIGNED_SHORT_4_4_4_4: origin_ctx.UNSIGNED_SHORT_4_4_4_4,
            UNSIGNED_SHORT_5_5_5_1: origin_ctx.UNSIGNED_SHORT_5_5_5_1,
            UNSIGNED_SHORT_5_6_5: origin_ctx.UNSIGNED_SHORT_5_6_5,

            // Shaders
            FRAGMENT_SHADER: origin_ctx.FRAGMENT_SHADER,
            VERTEX_SHADER: origin_ctx.VERTEX_SHADER,
            MAX_VERTEX_ATTRIBS: origin_ctx.MAX_VERTEX_ATTRIBS,
            MAX_VERTEX_UNIFORM_VECTORS: origin_ctx.MAX_VERTEX_UNIFORM_VECTORS,
            MAX_VARYING_VECTORS: origin_ctx.MAX_VARYING_VECTORS,
            MAX_COMBINED_TEXTURE_IMAGE_UNITS: origin_ctx.MAX_COMBINED_TEXTURE_IMAGE_UNITS,
            MAX_VERTEX_TEXTURE_IMAGE_UNITS: origin_ctx.MAX_VERTEX_TEXTURE_IMAGE_UNITS,
            MAX_TEXTURE_IMAGE_UNITS: origin_ctx.MAX_TEXTURE_IMAGE_UNITS,
            MAX_FRAGMENT_UNIFORM_VECTORS: origin_ctx.MAX_FRAGMENT_UNIFORM_VECTORS,
            SHADER_TYPE: origin_ctx.SHADER_TYPE,
            DELETE_STATUS: origin_ctx.DELETE_STATUS,
            LINK_STATUS: origin_ctx.LINK_STATUS,
            VALIDATE_STATUS: origin_ctx.VALIDATE_STATUS,
            ATTACHED_SHADERS: origin_ctx.ATTACHED_SHADERS,
            ACTIVE_UNIFORMS: origin_ctx.ACTIVE_UNIFORMS,
            ACTIVE_UNIFORM_MAX_LENGTH: origin_ctx.ACTIVE_UNIFORM_MAX_LENGTH,
            ACTIVE_ATTRIBUTES: origin_ctx.ACTIVE_ATTRIBUTES,
            ACTIVE_ATTRIBUTE_MAX_LENGTH: origin_ctx.ACTIVE_ATTRIBUTE_MAX_LENGTH,
            SHADING_LANGUAGE_VERSION: origin_ctx.SHADING_LANGUAGE_VERSION,
            CURRENT_PROGRAM: origin_ctx.CURRENT_PROGRAM,

            // StencilFunction
            NEVER: origin_ctx.NEVER,
            LESS: origin_ctx.LESS,
            EQUAL: origin_ctx.EQUAL,
            LEQUAL: origin_ctx.LEQUAL,
            GREATER: origin_ctx.GREATER,
            NOTEQUAL: origin_ctx.NOTEQUAL,
            GEQUAL: origin_ctx.GEQUAL,
            ALWAYS: origin_ctx.ALWAYS,

            // StencilOp
            // GL_ZERO
            KEEP: origin_ctx.KEEP,
            REPLACE: origin_ctx.REPLACE,
            INCR: origin_ctx.INCR,
            DECR: origin_ctx.DECR,
            INVERT: origin_ctx.INVERT,
            INCR_WRAP: origin_ctx.INCR_WRAP,
            DECR_WRAP: origin_ctx.DECR_WRAP,

            // StringName
            VENDOR: origin_ctx.VENDOR,
            RENDERER: origin_ctx.RENDERER,
            VERSION: origin_ctx.VERSION,
            EXTENSIONS: origin_ctx.EXTENSIONS,

            // TextureMagFilter
            NEAREST: origin_ctx.NEAREST,
            LINEAR: origin_ctx.LINEAR,

            // TextureMinFilter
            // GL_NEAREST
            // GL_LINEAR
            NEAREST_MIPMAP_NEAREST: origin_ctx.NEAREST_MIPMAP_NEAREST,
            LINEAR_MIPMAP_NEAREST: origin_ctx.LINEAR_MIPMAP_NEAREST,
            NEAREST_MIPMAP_LINEAR: origin_ctx.NEAREST_MIPMAP_LINEAR,
            LINEAR_MIPMAP_LINEAR: origin_ctx.LINEAR_MIPMAP_LINEAR,

            // TextureParameterName
            TEXTURE_MAG_FILTER: origin_ctx.TEXTURE_MAG_FILTER,
            TEXTURE_MIN_FILTER: origin_ctx.TEXTURE_MIN_FILTER,
            TEXTURE_WRAP_S: origin_ctx.TEXTURE_WRAP_S,
            TEXTURE_WRAP_T: origin_ctx.TEXTURE_WRAP_T,

            // TextureTarget
            // GL_TEXTURE_2D
            TEXTURE: origin_ctx.TEXTURE,

            TEXTURE_CUBE_MAP: origin_ctx.TEXTURE_CUBE_MAP,
            TEXTURE_BINDING_CUBE_MAP: origin_ctx.TEXTURE_BINDING_CUBE_MAP,
            TEXTURE_CUBE_MAP_POSITIVE_X: origin_ctx.TEXTURE_CUBE_MAP_POSITIVE_X,
            TEXTURE_CUBE_MAP_NEGATIVE_X: origin_ctx.TEXTURE_CUBE_MAP_NEGATIVE_X,
            TEXTURE_CUBE_MAP_POSITIVE_Y: origin_ctx.TEXTURE_CUBE_MAP_POSITIVE_Y,
            TEXTURE_CUBE_MAP_NEGATIVE_Y: origin_ctx.TEXTURE_CUBE_MAP_NEGATIVE_Y,
            TEXTURE_CUBE_MAP_POSITIVE_Z: origin_ctx.TEXTURE_CUBE_MAP_POSITIVE_Z,
            TEXTURE_CUBE_MAP_NEGATIVE_Z: origin_ctx.TEXTURE_CUBE_MAP_NEGATIVE_Z,
            MAX_CUBE_MAP_TEXTURE_SIZE: origin_ctx.MAX_CUBE_MAP_TEXTURE_SIZE,

            // TextureUnit
            TEXTURE0: 33984,
            TEXTURE1: origin_ctx.TEXTURE1,
            TEXTURE2: origin_ctx.TEXTURE2,
            TEXTURE3: origin_ctx.TEXTURE3,
            TEXTURE4: origin_ctx.TEXTURE4,
            TEXTURE5: origin_ctx.TEXTURE5,
            TEXTURE6: origin_ctx.TEXTURE6,
            TEXTURE7: origin_ctx.TEXTURE7,
            TEXTURE8: origin_ctx.TEXTURE8,
            TEXTURE9: origin_ctx.TEXTURE9,
            TEXTURE10: origin_ctx.TEXTURE10,
            TEXTURE11: origin_ctx.TEXTURE11,
            TEXTURE12: origin_ctx.TEXTURE12,
            TEXTURE13: origin_ctx.TEXTURE13,
            TEXTURE14: origin_ctx.TEXTURE14,
            TEXTURE15: origin_ctx.TEXTURE15,
            TEXTURE16: origin_ctx.TEXTURE16,
            TEXTURE17: origin_ctx.TEXTURE17,
            TEXTURE18: origin_ctx.TEXTURE18,
            TEXTURE19: origin_ctx.TEXTURE19,
            TEXTURE20: origin_ctx.TEXTURE20,
            TEXTURE21: origin_ctx.TEXTURE21,
            TEXTURE22: origin_ctx.TEXTURE22,
            TEXTURE23: origin_ctx.TEXTURE23,
            TEXTURE24: origin_ctx.TEXTURE24,
            TEXTURE25: origin_ctx.TEXTURE25,
            TEXTURE26: origin_ctx.TEXTURE26,
            TEXTURE27: origin_ctx.TEXTURE27,
            TEXTURE28: origin_ctx.TEXTURE28,
            TEXTURE29: origin_ctx.TEXTURE29,
            TEXTURE30: origin_ctx.TEXTURE30,
            TEXTURE31: origin_ctx.TEXTURE31,
            ACTIVE_TEXTURE: origin_ctx.ACTIVE_TEXTURE,

            // TextureWrapMode
            REPEAT: origin_ctx.REPEAT,
            CLAMP_TO_EDGE: origin_ctx.CLAMP_TO_EDGE,
            MIRRORED_REPEAT: origin_ctx.MIRRORED_REPEAT,

            // Uniform Types
            FLOAT_VEC2: origin_ctx.FLOAT_VEC2,
            FLOAT_VEC3: origin_ctx.FLOAT_VEC3,
            FLOAT_VEC4: origin_ctx.FLOAT_VEC4,
            INT_VEC2: origin_ctx.INT_VEC2,
            INT_VEC3: origin_ctx.INT_VEC3,
            INT_VEC4: origin_ctx.INT_VEC4,
            BOOL: origin_ctx.BOOL,
            BOOL_VEC2: origin_ctx.BOOL_VEC2,
            BOOL_VEC3: origin_ctx.BOOL_VEC3,
            BOOL_VEC4: origin_ctx.BOOL_VEC4,
            FLOAT_MAT2: origin_ctx.FLOAT_MAT2,
            FLOAT_MAT3: origin_ctx.FLOAT_MAT3,
            FLOAT_MAT4: origin_ctx.FLOAT_MAT4,
            SAMPLER_2D: origin_ctx.SAMPLER_2D,
            SAMPLER_CUBE: origin_ctx.SAMPLER_CUBE,

            // Vertex Arrays
            VERTEX_ATTRIB_ARRAY_ENABLED: origin_ctx.VERTEX_ATTRIB_ARRAY_ENABLED,
            VERTEX_ATTRIB_ARRAY_SIZE: origin_ctx.VERTEX_ATTRIB_ARRAY_SIZE,
            VERTEX_ATTRIB_ARRAY_STRIDE: origin_ctx.VERTEX_ATTRIB_ARRAY_STRIDE,
            VERTEX_ATTRIB_ARRAY_TYPE: origin_ctx.VERTEX_ATTRIB_ARRAY_TYPE,
            VERTEX_ATTRIB_ARRAY_NORMALIZED: origin_ctx.VERTEX_ATTRIB_ARRAY_NORMALIZED,
            VERTEX_ATTRIB_ARRAY_POINTER: origin_ctx.VERTEX_ATTRIB_ARRAY_POINTER,
            VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: origin_ctx.VERTEX_ATTRIB_ARRAY_BUFFER_BINDING,

            // Read Format
            IMPLEMENTATION_COLOR_READ_TYPE: origin_ctx.IMPLEMENTATION_COLOR_READ_TYPE,
            IMPLEMENTATION_COLOR_READ_FORMAT: origin_ctx.IMPLEMENTATION_COLOR_READ_FORMAT,

            // Shader Source
            COMPILE_STATUS: origin_ctx.COMPILE_STATUS,
            INFO_LOG_LENGTH: origin_ctx.INFO_LOG_LENGTH,
            SHADER_SOURCE_LENGTH: origin_ctx.SHADER_SOURCE_LENGTH,
            SHADER_COMPILER: origin_ctx.SHADER_COMPILER,

            // Shader Binary
            SHADER_BINARY_FORMATS: origin_ctx.SHADER_BINARY_FORMATS,
            NUM_SHADER_BINARY_FORMATS: origin_ctx.NUM_SHADER_BINARY_FORMATS,

            // Shader Precision-Specified Types
            LOW_FLOAT: origin_ctx.LOW_FLOAT,
            MEDIUM_FLOAT: origin_ctx.MEDIUM_FLOAT,
            HIGH_FLOAT: origin_ctx.HIGH_FLOAT,
            LOW_INT: origin_ctx.LOW_INT,
            MEDIUM_INT: origin_ctx.MEDIUM_INT,
            HIGH_INT: origin_ctx.HIGH_INT,

            // Framebuffer Object.
            FRAMEBUFFER: origin_ctx.FRAMEBUFFER,
            RENDERBUFFER: origin_ctx.RENDERBUFFER,

            RGBA4: origin_ctx.RGBA4,
            RGB5_A1: origin_ctx.RGB5_A1,
            RGB565: origin_ctx.RGB565,
            DEPTH_COMPONENT16: origin_ctx.DEPTH_COMPONENT16,

            // Not sure if it makes sense to alias STENCIL_INDEX or if it should be
            // removed completely.

            STENCIL_INDEX: origin_ctx.STENCIL_INDEX,
            STENCIL_INDEX8: origin_ctx.STENCIL_INDEX8,
            DEPTH_STENCIL: origin_ctx.DEPTH_STENCIL,

            RENDERBUFFER_WIDTH: origin_ctx.RENDERBUFFER_WIDTH,
            RENDERBUFFER_HEIGHT: origin_ctx.RENDERBUFFER_HEIGHT,
            RENDERBUFFER_INTERNAL_FORMAT: origin_ctx.RENDERBUFFER_INTERNAL_FORMAT,
            RENDERBUFFER_RED_SIZE: origin_ctx.RENDERBUFFER_RED_SIZE,
            RENDERBUFFER_GREEN_SIZE: origin_ctx.RENDERBUFFER_GREEN_SIZE,
            RENDERBUFFER_BLUE_SIZE: origin_ctx.RENDERBUFFER_BLUE_SIZE,
            RENDERBUFFER_ALPHA_SIZE: origin_ctx.RENDERBUFFER_ALPHA_SIZE,
            RENDERBUFFER_DEPTH_SIZE: origin_ctx.RENDERBUFFER_DEPTH_SIZE,
            RENDERBUFFER_STENCIL_SIZE: origin_ctx.RENDERBUFFER_STENCIL_SIZE,

            FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: origin_ctx.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE,
            FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: origin_ctx.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME,
            FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: origin_ctx.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL,
            FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: origin_ctx.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE,

            COLOR_ATTACHMENT0: origin_ctx.COLOR_ATTACHMENT0,
            DEPTH_ATTACHMENT: origin_ctx.DEPTH_ATTACHMENT,
            STENCIL_ATTACHMENT: origin_ctx.STENCIL_ATTACHMENT,
            DEPTH_STENCIL_ATTACHMENT: origin_ctx.DEPTH_STENCIL_ATTACHMENT,

            NONE: origin_ctx.NONE,

            FRAMEBUFFER_COMPLETE: origin_ctx.FRAMEBUFFER_COMPLETE,
            FRAMEBUFFER_INCOMPLETE_ATTACHMENT: origin_ctx.FRAMEBUFFER_INCOMPLETE_ATTACHMENT,
            FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: origin_ctx.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT,
            FRAMEBUFFER_INCOMPLETE_DIMENSIONS: origin_ctx.FRAMEBUFFER_INCOMPLETE_DIMENSIONS,
            FRAMEBUFFER_UNSUPPORTED: origin_ctx.FRAMEBUFFER_UNSUPPORTED,

            FRAMEBUFFER_BINDING: origin_ctx.FRAMEBUFFER_BINDING,
            RENDERBUFFER_BINDING: origin_ctx.RENDERBUFFER_BINDING,
            MAX_RENDERBUFFER_SIZE: origin_ctx.MAX_RENDERBUFFER_SIZE,

            INVALID_FRAMEBUFFER_OPERATION: origin_ctx.INVALID_FRAMEBUFFER_OPERATION,

            // WebGL-specific enums
            UNPACK_FLIP_Y_WEBGL: origin_ctx.UNPACK_FLIP_Y_WEBGL,
            UNPACK_PREMULTIPLY_ALPHA_WEBGL: origin_ctx.UNPACK_PREMULTIPLY_ALPHA_WEBGL,
            CONTEXT_LOST_WEBGL: origin_ctx.CONTEXT_LOST_WEBGL,
            UNPACK_COLORSPACE_CONVERSION_WEBGL: origin_ctx.UNPACK_COLORSPACE_CONVERSION_WEBGL,
            BROWSER_DEFAULT_WEBGL: origin_ctx.BROWSER_DEFAULT_WEBGL,
        }

        Object.defineProperty(__WebGLRenderingContextProto__, "drawingBufferWidth", {
            get: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(146);
                return commandBufferData.batchRender();
            },
            configurable: true,
            enumerable: true
        });
        Object.defineProperty(__WebGLRenderingContextProto__, "drawingBufferHeight", {
            get: function () {
                checkContextChange(_(this).ctxid);
                commandBufferData.pushInt32(147);
                return commandBufferData.batchRender();
            },
            configurable: true,
            enumerable: true
        });

        var batchGL = Object.create(__WebGLRenderingContextProto__);
        _(batchGL).origin_ctx = origin_ctx;
        _(batchGL).ctxid = origin_ctx.__uid();

        /*
            Object.getOwnPropertyNames(__WebGLRenderingContextProto__).forEach(function (name) {
                var origin = batchGL[name];
                if (origin instanceof Function && name != 'batchRender') {
                    batchGL[name] = function() {
                        // var argumentsStr = [];
                        // [...arguments].forEach(function(arg) {
                        //     if (arg == null){
                        //         argumentsStr.push(0);
                        //     } else if (arg['uid'] != undefined) {
                        //         argumentsStr.push(arg['uid']);
                        //     } else if (arg['id'] != undefined) {
                        //         argumentsStr.push(arg['id']);
                        //     } else {
                        //         argumentsStr.push(arg);
                        //     }
                        // })
                        // ejlog("call " + name + "(" + argumentsStr.toString() + ")");
                        // var startPos = commandBufferData.meta[0];
                        // if (commandBufferData.startTime == null) {
                        //     commandBufferData.startTime = new Date();
                        // }
                        var startTime = nativePerformanceNow();
                        var result = origin.apply(batchGL, arguments);
                        var costTime = nativePerformanceNow() - startTime;
                        if (!commandBufferData.commandCostTime[name]) {
                            commandBufferData.commandCostTime[name] = {
                                count: 0,
                                totalTime: 0
                            };
                        }
                        commandBufferData.commandCostTime[name].totalTime += costTime;
                        commandBufferData.commandCostTime[name].count += 1;
        
                        // var endPos = commandBufferData.meta[0];
                        // ejlog("commandbuffer len: " + (endPos - startPos));
                        // if (endPos > startPos) {
                            // commandBufferData.endTime = new Date();
                            // return commandBufferData.batchRender();
                            // var bytes = new Uint32Array(commandBufferData.buffer, startPos + 4, (endPos - startPos - 4) / 4);
                            // ejlog("Uint32: " + bytes);
                            // bytes = new Float32Array(commandBufferData.buffer, startPos + 4, (endPos - startPos - 4) / 4);
                            // ejlog("Float32: " + bytes);
                        // }
                        return result;
                    }
                }
            })
        */
        return batchGL;
    };

})();