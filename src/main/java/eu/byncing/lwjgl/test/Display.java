package eu.byncing.lwjgl.test;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Display {

    private long id;

    public Display(String title, int width, int height) {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) throw new IllegalStateException("Glfw cannot be initialized");
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        this.id = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        GLFW.glfwMakeContextCurrent(id);
        GLFW.glfwSwapInterval(1);

        GL.createCapabilities();
    }

    public void start(Runnable runnable) {
        while (!GLFW.glfwWindowShouldClose(id)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            runnable.run();

            GLFW.glfwSwapBuffers(id);
            GLFW.glfwPollEvents();
        }
    }

    public void show() {
        GLFW.glfwShowWindow(id);
    }

    public void destroy() {
        GLFW.glfwDestroyWindow(id);
    }

    public long getId() {
        return id;
    }
}