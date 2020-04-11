/*

 AnimationEfect v1.0.1 - source code for AnimationEfect application
 Copyright (C) 2020 softpang

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    
 Redistribution and use in source and binary forms, with or without modification,
 are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice,
 this list of conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 3. Neither the name of the copyright holder nor the names of its contributors
 may be used to endorse or promote products derived from this software without
 specific prior written permission. 

 */
package util;

import animation.TypeContainer;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 * @company softpang   https://www.softpang.com/
 * @author bitPanG98     https://github.com/bitPanG98
 * @date 06-abr-2020 21:13:56
 * @class AnimationEfect 
 *
 */

public class Util {

    public static final int WINDOWS = 0;
    public static final int WINDOWS_XP = 1;
    public static final int WINDOWS_VISTA = 2;
    public static final int WINDOWS_7 = 3;
    public static final int WINDOWS_8 = 4;
    public static final int WINDOWS_10 = 5;
    public static final int MAC_OS = 9;
    public static final int LINUX = 10;
    public static final int UNIX = 11;
    public static final int OTHER = 20;
    public static int operativeSystem;

    public void operativeSystem() {

        String str = System.getProperty("os.name").toLowerCase();
        if (str.contains("windows")) {
            if (str.contains("xp")) {
                operativeSystem = 1;
            } else if (str.contains("vista")) {
                operativeSystem = 2;
            } else if (str.contains("7")) {
                operativeSystem = 3;
            } else if (str.contains("8")) {
                operativeSystem = 4;
            } else if (str.contains("10")) {
                operativeSystem = 5;
            } else {
                operativeSystem = 0;
            }
        } else if (str.contains("mac")) {
            operativeSystem = 9;
        } else if (str.contains("linux")) {
            operativeSystem = 10;
        } else if (str.contains("unix")) {
            operativeSystem = 11;
        } else {
            operativeSystem = 20;
        }
    }

    public static int getOperativeSystem() {
        return operativeSystem;
    }

    public static boolean isTranslucencySupported() {

        boolean supportedNativeTranslucency;

        if (System.getProperty("java.version").contains("1.6")) {
            System.err.println("Per-pixel translucency is currently not supported.\nPlease upgrade your JRE to at least Java 7 to support this feature.");
            supportedNativeTranslucency = false;
        } else {

            // Determine qué puede admitir el GraphicsDevice predeterminado.
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();

            /*
             TRANSLUCENT - La plataforma subyacente admite ventanas con translucidez uniforme, donde cada píxel tiene el mismo valor alfa.
             PERPIXEL_TRANSLUCENT- La plataforma subyacente admite ventanas con translucidez por píxel. Esta capacidad es necesaria para implementar ventanas que se desvanecen.
             */
            boolean isUniformTranslucencySupported = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);
            boolean isPerPixelTranslucencySupported = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT);

            if (!isPerPixelTranslucencySupported) {
                System.err.println("Error while starting: Per-pixel translucency is not supported.");
                supportedNativeTranslucency = false;
            } else {
                supportedNativeTranslucency = true;
            }
        }

        return supportedNativeTranslucency;
    }

    public static boolean isShapedWindowSupported() {

        boolean supportedNativeShape;

        if (System.getProperty("java.version").contains("1.6")) {
            System.err.println("PER-PIXEL TRANSPARENT is currently not supported.\nPlease upgrade your JRE to at least Java 7 to support this feature.");
            supportedNativeShape = false;
        } else {

            // Determine qué puede admitir el GraphicsDevice predeterminado.
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();

            /* PERPIXEL_TRANSPARENT - La plataforma subyacente admite ventanas con forma.*/
            boolean isShapedWindowSupported = gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT);

            if (!isShapedWindowSupported) {
                System.err.println("Error while starting: PER-PIXEL TRANSPARENT is not supported.");
                supportedNativeShape = false;
            } else {
                supportedNativeShape = true;
            }
        }

        return supportedNativeShape;
    }

    public static boolean isContainerAllowed(Container container) {

        boolean isTypeContainer = false;

        if (container instanceof JFrame) {
            isTypeContainer = true;
        } else if (container instanceof JDialog) {
            isTypeContainer = true;
        } else {
            isTypeContainer = false;
        }

        return isTypeContainer;
    }

    public static boolean isWindowUndecorate(TypeContainer typeContainer) {

        boolean isUndecorate = false;

        if (typeContainer.getMiFrame() != null) {
            isUndecorate = typeContainer.getMiFrame().isUndecorated();
        } else if (typeContainer.getMiDialog() != null) {
            isUndecorate = typeContainer.getMiDialog().isUndecorated();
        } else {
            System.err.println("[!]> The window  should not be null. ");
        }

        return isUndecorate;
    }

    public static enum Direction {

        LEFT(false),
        RIGHT(false),
        UP(true),
        DOWN(true);

        private final boolean vertical;

        private Direction(boolean vertical) {
            this.vertical = vertical;
        }

        public boolean isVertical() {
            return this.vertical;
        }
    }

}
