# 📚 Estruturas de Dados - LISTAS

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Ativo-brightgreen.svg)](https://github.com/GabrielGit10110/data-structures-java)

Uma biblioteca completa e eficiente de estruturas de dados lineares implementadas em Java, perfeita para estudos acadêmicos e projetos práticos.

## 🏗️ Estruturas Implementadas

### 🔗 **LinkedList<T>** - Lista Simplesmente Encadeada
- **Inserção**: `append()`, `prepend()`, `insert()`
- **Remoção**: `removeFirst()`, `removeLast()`, `remove()`
- **Busca**: `get()`, `getFirst()`, `getLast()`, `indexOf()`, `lastIndexOf()`, `contains()`
- **Utilitários**: `size()`, `isEmpty()`, `clear()`, `toString()`

### 🔄 **DoublyLinkedList<T>** - Lista Duplamente Encadeada
- **Inserção**: `append()`, `insert()`
- **Remoção**: `remove()`
- **Busca**: `get()`, `index()`
- **Utilitários**: `size()`, `isEmpty()`

### 🔁 **CircularLinkedList<T>** - Lista Circular
- **Inserção**: `append()`
- **Remoção**: `remove()`
- **Utilitários**: `toString()`

## 🚀 Começando

### 📥 Instalação

#### Método 1: Clone o repositório
```bash
git clone https://github.com/GabrielGit10110/data-structures-java.git
cd data-structures-java
```

#### Método 2: Download do JAR
```bash
# Compilar do código fonte
javac -d bin src/com/Roukan/datastructures/list/*.java
jar cf dataStructures.jar -C bin .
```

### 💻 Uso Básico

```java
import com.Roukan.datastructures.list.LinkedList;
import com.Roukan.datastructures.list.DoublyLinkedList;
import com.Roukan.datastructures.list.CircularLinkedList;

// Lista Simplesmente Encadeada
LinkedList<String> simpleList = new LinkedList<>();
simpleList.append("Primeiro");
simpleList.prepend("Segundo");
simpleList.insert(1, "Inserido");
System.out.println(simpleList); // [Segundo, Inserido, Primeiro]

// Lista Duplamente Encadeada
DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
doublyList.append(10);
doublyList.append(20);
doublyList.append(30);
System.out.println(doublyList.get(1)); // 20

// Lista Circular
CircularLinkedList<Character> circularList = new CircularLinkedList<>();
circularList.append('A');
circularList.append('B');
circularList.append('C');
System.out.println(circularList); // [A, B, C]
```

## 📊 Comparação de Performance

| Operação | LinkedList | DoublyLinkedList | CircularLinkedList |
|----------|------------|------------------|-------------------|
| `append()` | O(n) | O(1) | O(1) |
| `prepend()` | O(1) | - | - |
| `get(index)` | O(n) | O(n) | O(n) |
| `removeFirst()` | O(1) | - | - |
| `removeLast()` | O(n) | - | - |

## 🎯 Casos de Uso Recomendados

### LinkedList
- ✅ Quando há muitas inserções no início
- ✅ Aplicações com operações FIFO (First-In-First-Out)
- ✅ Implementação de pilhas (stacks)

### DoublyLinkedList
- ✅ Navegação bidirecional necessária
- ✅ Histórico de navegação (voltar/avançar)
- ✅ Implementação de deques

### CircularLinkedList
- ✅ Aplicações round-robin
- ✅ Buffer circular
- ✅ Jogos e simulações


## 🏗️ Estrutura do Projeto

```
src/
└── com/Roukan/datastructures/list/
    ├── LinkedList.java          # Lista simplesmente encadeada
    ├── DoublyLinkedList.java    # Lista duplamente encadeada  
    ├── CircularLinkedList.java  # Lista circular
    ├── Node.java               # Nó simples
    ├── DoublyNode.java         # Nó duplo
    └── CircularNode.java       # Nó circular
```

## 📚 Documentação

A documentação completa da API com Javadoc está disponível em:  
🔗 **[GitHub Pages - DataStructures Documentation](https://gabrielgit10110.github.io/EstruturasDeLista/)**


## 🤝 Contribuindo

Contribuições são bem-vindas! Siga estos passos:

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/NovaFeature`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. **Push** para a branch (`git push origin feature/NovaFeature`)
5. Abra um **Pull Request**

### 📋 Padrões de Código
- Use nomes descritivos para variáveis e métodos
- Mantenha a consistência no estilo Java
- Adicione comentários para lógicas complexas
- Teste suas mudanças antes de submeter

## 🐛 Reportando Problemas

Encontrou um bug? [Abra uma issue](https://github.com/GabrielGit10110/data-structures-java/issues) incluindo:
- Descrição detalhada do problema
- Passos para reproduzir
- Comportamento esperado vs atual
- Ambiente (Java version, SO)

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👨‍💻 Autor

**Gabriel** - [GabrielGit10110](https://github.com/GabrielGit10110)

- GitHub: [@GabrielGit10110](https://github.com/GabrielGit10110)

## 🌟 Agradecimentos

- Inspirado nas minhas aulas de estruturas de dados da faculdade
- Comunidade Java por boas práticas

---

**⭐ Não esqueça de dar uma estrela no repositório se achou útil!**

---

<div align="center">
  
Feito com ❤️ e ☕ por Gabriel

[⬆ Voltar ao topo](#-estruturas-de-dados-em-java)

</div>

---
