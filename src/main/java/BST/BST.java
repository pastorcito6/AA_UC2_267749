package BST;

// Clase que representa un nodo individual del árbol
class Nodo {
    int valor;
    Nodo izq;
    Nodo der;

    public Nodo(int valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
}

public class BST {
    private Nodo raiz;

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izq = insertarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = insertarRecursivo(actual.der, valor);
        }
        return actual;
    }

    public boolean buscar(int clave) {
        return buscarRecursivo(raiz, clave);
    }

    private boolean buscarRecursivo(Nodo actual, int clave) {
        if (actual == null) return false;
        if (clave == actual.valor) return true;
        return clave < actual.valor ? buscarRecursivo(actual.izq, clave) : buscarRecursivo(actual.der, clave);
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izq = eliminarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = eliminarRecursivo(actual.der, valor);
        } else {
            if (actual.izq == null && actual.der == null) return null;
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            actual.valor = encontrarMinimo(actual.der);
            actual.der = eliminarRecursivo(actual.der, actual.valor);
        }
        return actual;
    }

    private int encontrarMinimo(Nodo actual) {
        int min = actual.valor;
        while (actual.izq != null) {
            min = actual.izq.valor;
            actual = actual.izq;
        }
        return min;
    }

    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual == null) return;
        inordenRecursivo(actual.izq);
        System.out.print(actual.valor + " ");
        inordenRecursivo(actual.der);
    }
}