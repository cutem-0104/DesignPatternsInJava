package composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

interface SomeNeurons extends Iterable<Neuron> {
    default void connectTo(SomeNeurons other) {
        if (this == other) return;

        for (Neuron from : this) {
            for (Neuron to : other) {
                from.out.add(to);
                to.in.add(from);
            }
        }
    }
}

class Neuron implements SomeNeurons {
    public ArrayList<Neuron> in, out;

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        // 渡されたオブジェクトを要素がひとつだけのコレクションに変換する
        return Collections.singleton(this).spliterator();
    }

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    //    public void connectTo(Neuron other) {
//        out.add(other);
//        other.in.add(this);
//    }
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {

}

class AAA {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron1 = new Neuron();
        NeuronLayer layer = new NeuronLayer();
        NeuronLayer layer1 = new NeuronLayer();

        neuron.connectTo(neuron1);
        neuron.connectTo(layer);
        layer.connectTo(neuron);
        layer.connectTo(layer1);

    }
}
