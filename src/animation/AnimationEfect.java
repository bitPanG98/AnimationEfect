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

 */
package animation;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Arc2D;
import static java.awt.geom.Arc2D.OPEN;
import static java.awt.geom.Arc2D.PIE;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Util;

/**
 * @company softpang https://www.softpang.com/
 * @author bitPanG98 https://github.com/bitPanG98
 * @date 06-abr-2020 21:13:56
 * @class AnimationEfect
 *
 */
public class AnimationEfect {

    //Window action after animation
    public static int ACTION_EXIT = 0;
    public static int ACTION_DISPOSE = 1;
    public static int ACTION_DO_NOTHING = 2;

    private static boolean typeContainerAllowed = false;
    private static TypeContainer typeContainer = null;

    public static void FadeOut(final long speed, Container miContainer, final int actionAfter) {

        if (!Util.isTranslucencySupported()) {
            System.err.println("[!]> Atencion: Translucency is not supported in this environment. ");
            System.exit(0);
        } else {

            typeContainerAllowed = Util.isContainerAllowed(miContainer);
            if (!typeContainerAllowed) {
                System.err.println("[!]> Atention: Container type not allowed. ");
            } else {

                typeContainer = new TypeContainer();
                typeContainer.setContainer(miContainer);

                if (!Util.isWindowUndecorate(typeContainer)) {
                    System.err.println("[!]>Atention:  The window is decorated, disable this property.");
                } else {

                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {

                            float opacity = 0.01f;

                            for (int i = 100; i >= 0; i--) {

                                try {

                                    Thread.sleep(speed);

                                    opacity = i * 0.01f;
                                    setWindowOpacity(opacity);

                                } catch (InterruptedException ex) {
                                    System.err.println("[!]> the thread is interrupted, either before or during the activity. \n" + ex.getMessage());
                                }

                            }
                            setActionAfter(actionAfter);

                        }

                    });
                    thread.start();

                }

            }

        }

    }

    public static void FadeOut(final int opacityStartLevel, final int opacityEndLevel, final long speed, Container miContainer, final int actionAfter) {

        if (!Util.isTranslucencySupported()) {
            System.err.println("[!]> Atencion: Translucency is not supported in this environment. ");
            System.exit(0);
        } else {

            typeContainerAllowed = Util.isContainerAllowed(miContainer);
            if (!typeContainerAllowed) {
                System.err.println("[!]> Atention: Container type not allowed. ");
            } else {

                typeContainer = new TypeContainer();
                typeContainer.setContainer(miContainer);

                if (!Util.isWindowUndecorate(typeContainer)) {
                    System.err.println("[!]>Atention:  The window is decorated, disable this property.");
                } else {

                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {

                            float opacity = 0.01f;

                            for (int i = opacityStartLevel; i >= opacityEndLevel; i--) {

                                try {

                                    Thread.sleep(speed);

                                    opacity = i * 0.01f;
                                    setWindowOpacity(opacity);

                                } catch (InterruptedException ex) {
                                    System.err.println("[!]> the thread is interrupted, either before or during the activity. \n" + ex.getMessage());
                                }

                            }
                            setActionAfter(actionAfter);

                        }

                    });
                    thread.start();

                }

            }

        }

    }

    public static void FadeIn(final long speed, Container miContainer, final int actionAfter) {

        typeContainer = new TypeContainer();

        if (!Util.isTranslucencySupported()) {
            System.err.println("[!]> Atencion: Translucency is not supported in this environment. ");
            System.exit(0);
        } else {

            typeContainerAllowed = Util.isContainerAllowed(miContainer);
            if (!typeContainerAllowed) {
                System.err.println("[!]> Atention: Container type not allowed. ");
            } else {

                typeContainer = new TypeContainer();
                typeContainer.setContainer(miContainer);

                if (!Util.isWindowUndecorate(typeContainer)) {
                    System.err.println("[!]> Atention: The window is decorated, disable this property.");
                } else {

                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {

                            float opacity = 0.01f;

                            for (int i = 100; i <= 0; i++) {

                                try {

                                    Thread.sleep(speed);

                                    opacity = i * 0.01f;
                                    setWindowOpacity(opacity);

                                } catch (InterruptedException ex) {
                                    System.out.println("[!]> Atention:  the thread is interrupted, either before or during the activity. \n" + ex.getMessage());
                                }

                            }
                            setActionAfter(actionAfter);

                        }

                    });
                    thread.start();

                }

            }

        }

    }

    public static void FadeIn(final int opacityStartLevel, final int opacityEndLevel, final long speed, Container miContainer, final int actionAfter) {

        typeContainer = new TypeContainer();

        if (!Util.isTranslucencySupported()) {
            System.err.println("[!]> Atencion: Translucency is not supported in this environment. ");
            System.exit(0);
        } else {

            typeContainerAllowed = Util.isContainerAllowed(miContainer);
            if (!typeContainerAllowed) {
                System.err.println("[!]> Atention: Container type not allowed. ");
            } else {

                typeContainer = new TypeContainer();
                typeContainer.setContainer(miContainer);

                if (!Util.isWindowUndecorate(typeContainer)) {
                    System.err.println("[!]> Atention: The window is decorated, disable this property.");
                } else {

                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {

                            float opacity = 0.01f;

                            for (int i = opacityStartLevel; i <= opacityEndLevel; i++) {

                                try {

                                    Thread.sleep(speed);

                                    opacity = i * 0.01f;
                                    setWindowOpacity(opacity);

                                } catch (InterruptedException ex) {
                                    System.out.println("[!]> Atention:  the thread is interrupted, either before or during the activity. \n" + ex.getMessage());
                                }

                            }
                            setActionAfter(actionAfter);

                        }

                    });
                    thread.start();

                }

            }

        }

    }

    private static void setWindowOpacity(float opacity) {

        if (typeContainer.getMiFrame() != null) {
            typeContainer.getMiFrame().setOpacity(opacity);
        } else if (typeContainer.getMiDialog() != null) {
            typeContainer.getMiDialog().setOpacity(opacity);
        } else {
            System.out.println("->  null window");
        }

    }

    private static void setActionAfter(int actionAfter) {

        if (actionAfter == ACTION_DISPOSE) {

            if (typeContainer.getMiFrame() != null) {
                typeContainer.getMiFrame().dispose();
            } else if (typeContainer.getMiDialog() != null) {
                typeContainer.getMiDialog().setVisible(false);
            } else {
                //pass
            }

        } else if (actionAfter == ACTION_EXIT) {
            System.exit(0);
        } else {
            //pass
        }

    }

    /*
     @param type The integer constant that represents the closure
     */
    public void setArcType(int type) {
        if (type < OPEN || type > PIE) {
            throw new IllegalArgumentException("invalid type for Arc: " + type);
        }
    }

    public static void Arc2D(final long speed, final Container miContainer, final int actionAfter) {

        typeContainerAllowed = Util.isContainerAllowed(miContainer);
        if (!typeContainerAllowed) {
            System.err.println("[!]> Atention: Container type not allowed. ");
        } else {

            typeContainer = new TypeContainer();
            typeContainer.setContainer(miContainer);

            if (!Util.isWindowUndecorate(typeContainer)) {
                System.err.println("[!]>Atention:  The window is decorated, disable this property.");
            } else {

                Thread hilo = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        for (int i = 0; i <= 360; i += 20) {
                            try {
                                Thread.sleep(300);

                                Arc2D a2D = new Arc2D.Double(0, 0, miContainer.getWidth(), miContainer.getHeight(), 0, i, Arc2D.OPEN);
                                if (typeContainer.getMiFrame() != null) {
                                    typeContainer.getMiFrame().setShape(a2D);
                                } else if (typeContainer.getMiDialog() != null) {
                                    typeContainer.getMiDialog().setShape(a2D);
                                } else {

                                }

                            } catch (InterruptedException ex) {
                                System.err.println("[!]> the thread is interrupted, either before or during the activity. \n" + ex.getMessage());
                            }

                        }
                        setActionAfter(actionAfter);
                    }
                });
                hilo.start();

            }
        }

    }

    public static void activateShapeRound(JFrame view, boolean activate) {
        if (activate) {
//            Shape forma = new RoundRectangle2D.Double(0, 0, view.getWidth(), view.getHeight(), 10000, 2000);
            for (int i = 0; i < view.getWidth(); i += 10) {

                Shape forma = new RoundRectangle2D.Double(0, 0, i, 10, 200, 200);
                AWTUtilities.setWindowShape(view, forma);
            }

        }
    }

    /**
     * TexBoxes that are in a container, change their background and border if
     * they are empty.
     *
     * @param container -> TextBox component container.
     *
     */
    public static void paintTextBoxEmpty(final Container container) {

        for (Component miComponent : container.getComponents()) {

            miComponent.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {

                    for (Component component : container.getComponents()) {

                        if (component instanceof JTextField
                                || component instanceof JPasswordField) {

                            String valueTextBox = ((JTextField) component).getText().trim().replace(" ", "");
                            if (valueTextBox.equals("")) {
                                ((JTextField) component).setBackground(new Color(255, 153, 153));
                                ((JTextField) component).
                                        setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));
                            } else {
                                ((JTextField) component).setBackground(Color.WHITE);
                                ((JTextField) component).
                                        setBorder(BorderFactory.createLineBorder(
                                                        new java.awt.Color(0, 204, 204), 1, true));
                            }
                        }

                    }

                }
            });

        }

    }

}
