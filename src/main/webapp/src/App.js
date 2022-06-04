import React, {Component} from 'react';
import Items from './components/items'

class App extends Component {
  state = {
    items: []
  }

  componentDidMount() {
    fetch('/items')
    .then(res => res.json())
    .then((data) => {
      this.setState({ items: data })
    })
    .catch(console.log)
  }

  render () {
    return (
      <Items items={this.state.items} />
    );
  }
}

export default App;
