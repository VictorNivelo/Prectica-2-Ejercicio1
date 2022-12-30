/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ListaEnlazada;

import Controlador.ListaEnlazada.Excepciones.AtributoException;
import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.Utilidades.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 *
 * @author Victor
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    private final Integer ascendente = 1;
    private final Integer descendente = 2;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }
    
    public void imprimir() {
        System.out.println("========================== LISTA RESTAURANTE ==========================");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\n");
            aux = aux.getSiguiente();
        }
        System.out.println("========================================================================\n");
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }
    
    public float generarNumeroAleatorio() {
        float numAleatorio = 0;
        numAleatorio = (float) (Math.random() * 1000);
        return numAleatorio;
    }

    public void llenarLista(Integer tamanio) {
        Object aux;
        for (int i = 0; i < tamanio; i++) {
            aux = generarNumeroAleatorio();
            insertar((E) aux);
        }
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);

        if (estaVacia()) {
            this.cabecera = nodo;

        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }
    
    public E obtener(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaExcepcion();
        }

    }

    public E eliminar(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }

                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaExcepcion();
        }

    }

    public E[] ComvertirEnArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public ListaEnlazada<E> ordenarShell(String atributo, Integer tipoOrdenacion) {
        E[] arreglo = ComvertirEnArray();
        Class<E> clazz = null;

        if (size > 0) {
            Integer intervalo, i, j, k;
            Integer n = arreglo.length;
            intervalo = n / 2;
            clazz = (Class<E>) cabecera.getDato().getClass();

            while (intervalo > 0) {
                for (i = intervalo; i < n; i++) {
                    j = i - intervalo;
                    while (j >= 0) {
                        k = j + intervalo;
                        j -= intervalo;
                    }
                }
                intervalo = intervalo / 2;
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }
        return this;
    }

    public void cambioDatoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion) {
        Class clazz = arreglo[0].getClass();
        Object aux;

        if (Utilidades.isString(clazz)) {
            if (Objects.equals(tipoOrdenacion, descendente)) {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
    }

    public void compararAtributoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion, String atributo, Class clazz) throws Exception {
        E auxJ = arreglo[j];
        E auxK = arreglo[k];
        Field field = Utilidades.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxJ);
            Object b = field.get(auxK);

            cambioObjetoShell(arreglo, a, b, j, k, tipoOrdenacion, atributo);
        }
    }
    
    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;

                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {

                NodoLista<E> aux = cabecera;

                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void cambioObjetoShell(E[] arreglo, Object auxJ, Object auxK, Integer j, Integer k, Integer tipoOrdenacion, String atributo) {
        Class clazz = auxJ.getClass();
        Object aux;
        if (Utilidades.isString(clazz)) {
            if (Objects.equals(tipoOrdenacion, descendente)) {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
    }

    public ListaEnlazada<E> QuickSort(String atributo, Integer tipoOrdenacion) {
        E[] arreglo = ComvertirEnArray();
        Class<E> clazz = null;

        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();

        }

        if (arreglo != null) {
            toList(arreglo);
        }
        return this;
    }

    public void QuickRecursivo(E[] arreglo, Integer primero, Integer ultimo, Integer tipoOrdenacion) {
        Integer i, j, central;
        E pivote;
        Object aux;

        central = (primero + ultimo) / 2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;
        Class clazz = (Class<E>) cabecera.getDato().getClass();


        do {
            if (Utilidades.isString(clazz)) {
                if (tipoOrdenacion == ascendente) {
                    while (arreglo[i].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                        i++;
                    }
                    while (arreglo[j].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                        j--;
                    }
                } else {
                    while (arreglo[i].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                        i++;
                    }
                    while (arreglo[j].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                        j--;
                    }
                }
            }
        } while (i <= j);

        if (primero < j) {
            QuickRecursivo(arreglo, primero, j, tipoOrdenacion);
        }
        if (i < ultimo) {
            QuickRecursivo(arreglo, i, ultimo, tipoOrdenacion);
        }

    }

    public void cambioDatoQuick(E[] arreglo, Integer i, Integer j) {
        Class clazz = arreglo[0].getClass();
        Object aux;

        if (Utilidades.isString(clazz)) {
            aux = (String) arreglo[j];
            arreglo[j] = arreglo[i];
            arreglo[i] = (E) aux;
        }
    }

    public void cambioObjectoQuick(E[] arreglo, Integer i, Integer j, Object auxI) {
        Class clazz = auxI.getClass();
        Object aux;

        if (Utilidades.isString(clazz)) {
            aux = arreglo[j];
            arreglo[j] = arreglo[i];
            arreglo[i] = (E) aux;
        }
    }

    public void ObjetoQuickRecursivo(E[] arreglo, Integer primero, Integer ultimo, Integer tipoOrdenacion, String atributo) throws Exception {
        Integer i, j, central;
        E pivote;
        Object a, b, c;

        central = (primero + ultimo) / 2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;
        Class clazz = (Class<E>) cabecera.getDato().getClass();

        Field field = Utilidades.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            a = field.get(arreglo[i]);
            b = field.get(arreglo[j]);
            c = field.get(pivote);
        }
        System.out.println(arreglo[i] + "\n" + arreglo[j] + "\n" + pivote);
        System.out.println(a + "\n" + b + "\n" + c);

        do {

        } while (i <= j);

        if (primero < j) {
            ObjetoQuickRecursivo(arreglo, primero, j, tipoOrdenacion, atributo);
        }
        if (i < ultimo) {
            ObjetoQuickRecursivo(arreglo, i, ultimo, tipoOrdenacion, atributo);
        }

    }

    public ListaEnlazada<E> busquedaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        if (size > 0) {
            E[] arreglo = ComvertirEnArray();
            clazz = (Class<E>) cabecera.getDato().getClass();

        }
        return resultado;
    }


    public ListaEnlazada<E> busquedaBinariaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E[] arreglo = ComvertirEnArray();
        Integer bajo = 0;
        Integer alto = arreglo.length - 1;
        Integer central = (bajo + alto) / 2;
        clazz = (Class<E>) cabecera.getDato().getClass();
        Object valorCentral = arreglo[central];

        return resultado;
    }

    private void compararObjetos(ListaEnlazada<E> resultado, E[] arreglo, Integer bajo, Integer alto, Integer central,
            Class clazz, String atributo, Object dato, Object valorCentral) throws Exception {
        Object a;

        Field field = Utilidades.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            a = field.get(valorCentral);
        }

        if (Utilidades.isString(a.getClass())) {
            if (dato.toString().toLowerCase().equals(a.toString().toLowerCase())) {
                resultado.insertar(arreglo[central]);
            } else if (dato.toString().toLowerCase().compareTo(a.toString().toLowerCase()) < 0) {
                alto = central;
                bajo = 0;
            } else {
                alto = arreglo.length - 1;
                bajo = central;
            }
            busquedaDeObjetos(resultado, bajo, alto, arreglo, clazz, atributo, dato);

        }

    }

    private void busquedaDeObjetos(ListaEnlazada<E> resultado, Integer bajo, Integer alto, E[] arreglo, Class clazz, String atributo, Object dato) throws Exception {
        Boolean band;
        for (int aux = bajo; bajo < alto + 1; bajo++) {
            band = EvaluacionBusquedaObjeto(arreglo[bajo], dato, clazz, atributo);
            if (band) {
                resultado.insertar(arreglo[bajo]);
            }
        }
    }

    private Boolean EvaluacionBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(aux);
        }
        return null;
    }

}
