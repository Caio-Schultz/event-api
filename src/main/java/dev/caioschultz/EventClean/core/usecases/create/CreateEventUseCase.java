package dev.caioschultz.EventClean.core.usecases.create;

import dev.caioschultz.EventClean.core.entities.Event;

public interface CreateEventUseCase {

    Event execute(Event event);

    // Quando se conectar lá na frente com a infra
    // vai fazer sentido colocar os nomes dos metodos como execute
    // vai ficar uma coisa como: createEventCase.execute();
    // fica implícito que a ação é criar um evento
    // não é preciso colocar o nome do metodo como create() por exemplo

}
