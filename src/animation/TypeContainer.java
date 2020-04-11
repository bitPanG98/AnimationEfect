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
package animation;

import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @company softpang   https://www.softpang.com/
 * @author bitPanG98     https://github.com/bitPanG98
 * @date 06-abr-2020 21:13:56
 * @class AnimationEfect 
 *
 */

public class TypeContainer {

    private Container container;
    private JFrame miFrame;
    private JDialog miDialog;

    private String nameTypeContainer = null;

    public TypeContainer() {
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;

        if (container instanceof JFrame) {
            this.miFrame = (JFrame) this.container;
            setMiFrame(miFrame);
        } else if (container instanceof JDialog) {
            this.miDialog = (JDialog) this.container;
            setMiDialog(miDialog);
        } else {
            System.err.println("[!]> Atention: Container type not allowed. ");
            setMiFrame(null);
            setMiDialog(null);
        }

    }

    public JFrame getMiFrame() {
        return miFrame;
    }

    public void setMiFrame(JFrame miFrame) {
        this.miFrame = miFrame;
    }

    public JDialog getMiDialog() {
        return miDialog;
    }

    public void setMiDialog(JDialog miDialog) {
        this.miDialog = miDialog;
    }

}
