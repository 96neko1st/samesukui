// easing関数
// jQuery Easing v1.3からの移植
/*
 * jQuery Easing v1.3 - http://gsgd.co.uk/sandbox/jquery/easing/
 *
 * Uses the built in easing capabilities added In jQuery 1.1
 * to offer multiple easing options
 *
 * TERMS OF USE - jQuery Easing
 *
 * Open source under the BSD License.
 *
 * Copyright ﾂｩ 2008 George McGinley Smith
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list
 * of conditions and the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * Neither the name of the author nor the names of contributors may be used to endorse
 * or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 *  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
/*
 *
 * TERMS OF USE - EASING EQUATIONS
 *
 * Open source under the BSD License.
 *
 * Copyright ﾂｩ 2001 Robert Penner
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list
 * of conditions and the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * Neither the name of the author nor the names of contributors may be used to endorse
 * or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 *  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package SameLib.Tween.Easing;

import SameLib.Event;
import SameLib.EventParam;
import SameLib.Timer;

import static com.jogamp.opengl.math.FloatUtil.*;

/**
 * easing関数
 * パラメータの説明
 * t: 経過時間
 * d: 設定時間
 */
public class EasingFunc {

    public static float easeInQuad(float t, float d) {
        return (t /= d) * t;
    }

    public static float easeOutQuad(float t, float d) {
        return -1f * (t /= d) * (t - 2f);
    }

    public static float easeInOutQuad(float t, float d) {
        if ((t /= d / 2) < 1) return 1f / 2f * t * t;
        return -1f / 2f * ((--t) * (t - 2) - 1);
    }

    public static float easeInCubic(float t, float d) {
        return (t /= d) * t * t;
    }

    public static float easeOutCubic(float t, float d) {
        return ((t = t / d - 1) * t * t + 1);
    }

    public static float easeInOutCubic(float t, float d) {
        if ((t /= d / 2) < 1) return 1f / 2 * t * t * t;
        return 1f / 2 * ((t -= 2) * t * t + 2);
    }

    public static float easeInQuart(float t, float d) {
        return (t /= d) * t * t * t;
    }

    public static float easeOutQuart(float t, float d) {
        return -1f * ((t = t / d - 1) * t * t * t - 1);
    }

    public static float easeInOutQuart(float t, float d) {
        if ((t /= d / 2) < 1) return 1f / 2 * t * t * t * t;
        return -1f / 2 * ((t -= 2) * t * t * t - 2);
    }

    public static float easeInQuint(float t, float d) {
        return (t /= d) * t * t * t * t;
    }

    public static float easeOutQuint(float t, float d) {
        return ((t = t / d - 1) * t * t * t * t + 1);
    }

    public static float easeInOutQuint(float t, float d) {
        if ((t /= d / 2) < 1) return 1f / 2 * t * t * t * t * t;
        return 1f / 2 * ((t -= 2) * t * t * t * t + 2);
    }

    public static float easeInSine(float t, float d) {
        return -1f * cos(t / d * (HALF_PI)) + 1f;
    }

    public static float easeOutSine(float t, float d) {
        return sin(t / d * (HALF_PI));
    }

    public static float easeInOutSine(float t, float d) {
        return -1f / 2 * (cos(PI * t / d) - 1);
    }

    public static float easeInExpo(float t, float d) {
        return (t == 0) ? 0f : pow(2, 10 * (t / d - 1));
    }

    public static float easeOutExpo(float t, float d) {
        return (t == d) ? 1f : -pow(2, -10 * t / d) + 1;
    }

    public static float easeInOutExpo(float t, float d) {
        if (t == 0) return 0f;
        if (t == d) return 1f;
        if ((t /= d / 2) < 1) return 1f / 2 * pow(2, 10 * (t - 1));
        return 1f / 2 * (-pow(2, -10 * --t) + 2);
    }

    public static float easeInCirc(float t, float d) {
        return -(sqrt(1 - (t /= d) * t) - 1);
    }

    public static float easeOutCirc(float t, float d) {
        return sqrt(1 - (t = t / d - 1) * t);
    }

    public static float easeInOutCirc(float t, float d) {
        if ((t /= d / 2) < 1) return -1f / 2 * (sqrt(1 - t * t) - 1);
        return 1f / 2 * (sqrt(1 - (t -= 2) * t) + 1);
    }

    public static float easeInElastic(float t, float d) {
        float s = 1.70158f;
        float p = 0;
        float a = 1f;
        if (t == 0) return 0f;
        if ((t /= d) == 1) return 1f;
        p = d * .3f;
        if (a < 1f) {
            a = 1f;
            s = p / 4;
        } else s = p / (2 * PI) * asin(1f / a);
        return -(a * pow(2, 10 * (t -= 1)) * sin((t * d - s) * (2 * PI) / p));
    }

    public static float easeOutElastic(float t, float d) {
        float s = 1.70158f;
        float p = 0;
        float a = 1f;
        if (t == 0) return 0f;
        if ((t /= d) == 1) return 1f;
        p = d * .3f;
        if (a < 1f) {
            a = 1f;
            s = p / 4;
        } else s = p / (TWO_PI) * asin(1f / a);
        return a * pow(2, -10 * t) * sin((t * d - s) * (2 * PI) / p) + 1f;
    }

    public static float easeInOutElastic(float t, float d) {
        float s = 1.70158f;
        float p = 0;
        float a = 1f;
        if (t == 0) return 0f;
        if ((t /= d / 2) == 2) return 1f;
        p = d * (.3f * 1.5f);
        if (a < 1f) {
            a = 1f;
            s = p / 4;
        } else s = p / (TWO_PI) * asin(1f / a);
        if (t < 1) return -.5f * (a * pow(2, 10 * (t -= 1)) * sin((t * d - s) * (TWO_PI) / p));
        return a * pow(2, -10 * (t -= 1)) * sin((t * d - s) * (TWO_PI) / p) * .5f + 1f;
    }

    public static float easeInBack(float t, float d) {
        float s = 1.70158f;
        return (t /= d) * t * ((s + 1) * t - s);
    }

    public static float easeOutBack(float t, float d) {
        float s = 1.70158f;
        return ((t = t / d - 1) * t * ((s + 1) * t + s) + 1);
    }

    public static float easeInOutBack(float t, float d) {
        float s = 1.70158f;
        if ((t /= d / 2) < 1) return 1f / 2 * (t * t * (((s *= (1.525)) + 1) * t - s));
        return 1f / 2 * ((t -= 2) * t * (((s *= (1.525)) + 1) * t + s) + 2);
    }

    public static float easeInBounce(float t, float d) {
        return 1f - easeOutBounce(d - t, d);
    }

    public static float easeOutBounce(float t, float d) {
        if ((t /= d) < (1 / 2.75f)) {
            return (7.5625f * t * t);
        } else if (t < (2 / 2.75f)) {
            return (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f);
        } else if (t < (2.5f / 2.75f)) {
            return (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f);
        } else {
            return (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f);
        }
    }

    public static float easeInOutBounce(float t, float d) {
        if (t < d / 2) return easeInBounce(t * 2, d) * .5f;
        return easeOutBounce(t * 2 - d, d) * .5f + .5f;
    }
}
