import React, {Component} from 'react';
import './App.css';

class App extends Component {
    render() {
        return (
            <div className="App">
                <form onSubmit={this.handleSearch}>
                    <input type="search"/>
                </form>
            </div>
        );
    }

    handleSearch() {

    }
}

export default App;
